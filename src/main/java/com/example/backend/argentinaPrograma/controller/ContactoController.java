/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.controller;

import com.example.backend.argentinaPrograma.model.Contacto;
import com.example.backend.argentinaPrograma.service.IContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Corrales Ulises
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ContactoController {

    @Autowired
    private IContactoService interContacto;

    @GetMapping("/contacto/traer")
    public Contacto traerContacto() {
        return interContacto.traerContacto();
    }

    @PutMapping("/contacto/editar")
    public void editarContacto(@RequestParam String telefono,
            @RequestParam String email,
            @RequestParam String linkedin,
            @RequestParam String twitter,
            @RequestParam String fb,
            @RequestParam String github) {
        Contacto contacto=interContacto.traerContacto();
        contacto.setEmail(email);
        contacto.setFacebook(fb);
        contacto.setLinkedin(linkedin);
        contacto.setTelefono(telefono);
        contacto.setTwitter(twitter);
        
        interContacto.saveContacto(contacto);
    }
}
