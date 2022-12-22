/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.controller;

import com.example.backend.argentinaPrograma.model.Mensaje;
import com.example.backend.argentinaPrograma.service.IMensajeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MensajeController {

    @Autowired
    private IMensajeService interMensaje;
       
    @GetMapping("/mensaje/traer")
    public List<Mensaje> nuevoMensaje() {   
        return interMensaje.getMensajes();
    }    
    @PostMapping("/mensaje/crear")
    public void crearMensaje(@RequestBody Mensaje mensaje) {
        interMensaje.saveMensaje(mensaje);        
    }
    @DeleteMapping("/mensaje/borrar/{id}")
    public String deleteMensaje(@PathVariable Long id) {
        interMensaje.deleteMensaje(id);

        return "Mensaje eliminado";
    }
    @PutMapping("/mensaje/editar/{id}")
    public Mensaje editMensaje(@PathVariable Long id,
            @RequestParam("organizacion") String organizacion,
            @RequestParam("contacto") String contacto,
            @RequestParam("mensaje") String mensaje){
        Mensaje msj=interMensaje.findMensaje(id);
        
        msj.setOrganizacion(organizacion);
        msj.setContacto(contacto);
        msj.setMensaje(mensaje);
        
        interMensaje.saveMensaje(msj);
        
        return msj;
    }
}
