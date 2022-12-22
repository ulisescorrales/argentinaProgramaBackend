/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.controller;

import com.example.backend.argentinaPrograma.model.Persona;
import com.example.backend.argentinaPrograma.service.IPersonaService;
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
public class PersonaController {
    
    @Autowired
    private IPersonaService interPersona;
    
    @GetMapping("/persona/traer")
    public Persona traerPersona(){
        return interPersona.getPersona();
    }
    @PutMapping("persona/editar")
    public void modificarPersona(@RequestParam String acercaDeMi,@RequestParam String fotoPerfil,@RequestParam String fotoFondo){        
        Persona pers=interPersona.getPersona();
        
        pers.setSobreMi(acercaDeMi);
        pers.setFotoPerfil(fotoPerfil);
        pers.setFotoFondo(fotoFondo);
        
        interPersona.savePersona(pers);
    }
}
