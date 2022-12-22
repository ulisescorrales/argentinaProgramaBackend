/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.controller;

import com.example.backend.argentinaPrograma.model.Educacion;
import com.example.backend.argentinaPrograma.service.IEducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Corrales Ulises
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EducacionController {    

    @Autowired
    private IEducacionService interEducacion;
    
    @GetMapping("/educacion/traer")
    public List<Educacion> getEducation() {
        return interEducacion.getEducacion();
    }

    @PostMapping("/educacion/agregar")
    public void putEducacion(Educacion ed) {
        interEducacion.saveEducacion(ed);
    }

    @GetMapping("/educacion/{id}")
    public Educacion finEducacion(@PathVariable Long id) {
        return interEducacion.findEducacion(id);
    }

    @PutMapping("/educacion/editar/{id}")
    public void putEducacion(@PathVariable Long id, @RequestParam String institucion,
            @RequestParam int anioIngreso,
            @RequestParam int duracion,
            @RequestParam int materiasTotales,
            @RequestParam int materiasAprobadas,
            @RequestParam String titulo) {
        Educacion ed = interEducacion.findEducacion(id);
        ed.setAnioIngreso(anioIngreso);
        ed.setDuracion(duracion);
        ed.setInstitucion(institucion);
        ed.setMateriasAprobadas(materiasAprobadas);
        ed.setTitulo(titulo);

        interEducacion.saveEducacion(ed);
    }
}
