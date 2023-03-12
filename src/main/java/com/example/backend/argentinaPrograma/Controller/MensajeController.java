/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.Controller;

import com.example.backend.argentinaPrograma.Model.Mensaje;
import com.example.backend.argentinaPrograma.Service.IMensajeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Corrales Ulises
 */
@RestController
public class MensajeController {

    @Autowired
    private IMensajeService interMensaje;
       
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/mensaje/traer")
    public List<Mensaje> nuevoMensaje() {   
        return interMensaje.getMensajes();
    }    
    @PostMapping("/mensaje/crear")
    public void crearMensaje(@RequestBody Mensaje mensaje) {
        interMensaje.saveMensaje(mensaje);                
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/mensaje/borrar/{id}")
    public String deleteMensaje(@PathVariable Long id) {
        interMensaje.deleteMensaje(id);

        return "Mensaje eliminado";
    }        
}
