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

    @GetMapping("/experiencia/{id}")
    public Experiencia finEducacion(@PathVariable Long id) {
        return interExperiencia.findExperiencia(id);
    }

    @PutMapping("/experiencia/editar/{id}")
    public void modificarExperiencia(@PathVariable Long id,
            @RequestBody String organizacion,
            @RequestBody Date inicio,
            @RequestBody Date fin,
            @RequestBody String descripcion,
            @RequestBody String logo) {
        Experiencia exp = interExperiencia.findExperiencia(id);
        exp.setDescripcion(descripcion);
        exp.setFin(fin);
        exp.setInicio(inicio);
        exp.setLogo(logo);
        exp.setOrganizacion(organizacion);

        interExperiencia.saveExperiencia(exp);
    }
}
