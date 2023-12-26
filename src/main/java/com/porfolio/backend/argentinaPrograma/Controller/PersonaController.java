/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.backend.argentinaPrograma.Controller;


import com.porfolio.backend.argentinaPrograma.Model.Persona;
import com.porfolio.backend.argentinaPrograma.Service.IPersonaService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Corrales Ulises
 */
@RestController
public class PersonaController {

    @Autowired
    private IPersonaService interPersona;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/auth/prueba")
    public void prueba() {
    }

    @GetMapping("/persona/traer")
    public Persona traerPersona() {        
        
        return interPersona.getPersona();
    }    

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("persona/editar")
    public void modificarPersona(@RequestBody Persona p) {
        Persona pers = interPersona.getPersona();

        pers.setApellido(p.getApellido());
        pers.setNombre(p.getNombre());
        pers.setSobreMi(p.getSobreMi());
        pers.setFotoPerfil(p.getFotoPerfil());
        pers.setFotoFondo(p.getFotoFondo());

        interPersona.savePersona(pers);
    }
}
