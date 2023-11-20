/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.backend.argentinaPrograma.Controller;

import com.porfolio.backend.argentinaPrograma.Model.Mensaje;
import com.porfolio.backend.argentinaPrograma.Service.IMensajeService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Corrales Ulises
 */
@RestController
public class MensajeController {

    @Autowired
    private IMensajeService interMensaje;
    @Value("${spring.chatbot}")
    String chatBot;
    @Value("${spring.chatId}")
    String chatId;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/mensaje/traer")
    public List<Mensaje> nuevoMensaje() {
        return interMensaje.getMensajes();
    }

    @PostMapping("/mensaje/crear")
    public void crearMensaje(@RequestBody Mensaje mensaje) {
        interMensaje.saveMensaje(mensaje);
        try {
            //Notificar el mensaje a un chatbot de telegram            
            String text = "Nuevo Mensaje\nDe:" + mensaje.getOrganizacion() + "\n" + "Contacto:" + mensaje.getContacto() + "\n" + "Mensaje:" + "\n" + mensaje.getMensaje();
            URL bot = new URL("https://api.telegram.org/bot" + this.chatBot + "/sendMessage");
            HttpURLConnection connection = (HttpURLConnection) bot.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            String jsonBody = "{\"chat_id\":\"" + this.chatId + "\",\"text\":\"" + text + "\"}";
            try (OutputStream outputStream = connection.getOutputStream()) {
                byte[] input = jsonBody.getBytes(StandardCharsets.UTF_8);
                outputStream.write(input, 0, input.length);
            }

            // Obtiene el código de respuesta de la solicitud
            //int responseCode = connection.getResponseCode();
            //System.out.println("Código de respuesta: " + responseCode);
            //StringBuilder response;
            try ( // Lee la respuesta de la solicitud
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                //String inputLine;
                //response = new StringBuilder();
                // while ((inputLine = reader.readLine()) != null) {
                //      response.append(inputLine);
                // }
            }

            // Imprime la respuesta
            //System.out.println("Respuesta: " + response.toString());
        } catch (MalformedURLException ex) {
            System.out.println("Url inválida");
        } catch (IOException ex) {
            System.out.println("Conexión no establecida");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/mensaje/borrar/{id}")
    public String deleteMensaje(@PathVariable Long id) {
        interMensaje.deleteMensaje(id);

        return "Mensaje eliminado";
    }
}
