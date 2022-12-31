/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.Controller;

import com.example.backend.argentinaPrograma.Model.Experiencia;
import com.example.backend.argentinaPrograma.Service.IExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RestController
public class ExperienciaController {

    @Autowired
    private IExperienciaService interExperiencia;

    @GetMapping("/experiencia/traer")
    public List<Experiencia> getEducation() {
        return interExperiencia.getExperiencia();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/experiencia/agregar")
    public void putEducacion(@RequestBody Experiencia ed) {
        interExperiencia.saveExperiencia(ed);
    }

    @GetMapping("/experiencia/traer/{id}")
    public Experiencia finEducacion(@PathVariable Long id) {
        return interExperiencia.findExperiencia(id);
    }
    @PreAuthorize("hasRole('ADMIN')")
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
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/editar/eliminar/experiencia/{id}")
    public void deleteExperiencia(@PathVariable Long id){
        this.interExperiencia.deleteExperiencia(id);
    }
}
