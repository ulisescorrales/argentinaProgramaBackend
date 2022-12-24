/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.controller;

import com.example.backend.argentinaPrograma.model.Experiencia;
import com.example.backend.argentinaPrograma.service.IExperienciaService;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Corrales Ulises
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ExperienciaController {

    @Autowired
    private IExperienciaService interExperiencia;

    @GetMapping("/experiencia/traer")
    public List<Experiencia> getEducation() {
        return interExperiencia.getExperiencia();
    }

    @PostMapping("/experiencia/agregar")
    public void putEducacion(Experiencia ed) {
        interExperiencia.saveExperiencia(ed);
    }

    @GetMapping("/experiencia/traer/{id}")
    public Experiencia finEducacion(@PathVariable Long id) {
        return interExperiencia.findExperiencia(id);
    }

    @PutMapping("/experiencia/editar/{id}")
    public void modificarExperiencia(@PathVariable Long id,
            @RequestBody Experiencia unaExp) {
        Experiencia exp = interExperiencia.findExperiencia(id);
        exp.setDescripcion(unaExp.getDescripcion());
        exp.setFin(unaExp.getFin());
        exp.setInicio(unaExp.getInicio());
        exp.setLogo(unaExp.getLogo());
        exp.setOrganizacion(unaExp.getOrganizacion());

        interExperiencia.saveExperiencia(exp);
    }
}
