/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.Controller;

import com.example.backend.argentinaPrograma.Model.Educacion;
import com.example.backend.argentinaPrograma.Service.IEducacionService;
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
public class EducacionController {    

    @Autowired
    private IEducacionService interEducacion;
    
    @GetMapping("/educacion/traer")
    public List<Educacion> getEducation() {
        return interEducacion.getEducacion();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/educacion/agregar")
    public void putEducacion(@RequestBody Educacion ed) {
        interEducacion.saveEducacion(ed);
    }

    @GetMapping("/educacion/{id}")
    public Educacion findEducacion(@PathVariable Long id) {
        Educacion education=interEducacion.findEducacion(id);
        //System.out.println(education.getCertificado());
        return education;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/educacion/editar/{id}")
    public void putEducacion(@PathVariable Long id, @RequestBody Educacion unaEd) {
        Educacion ed = interEducacion.findEducacion(id);        
        ed.setAnioIngreso(unaEd.getAnioIngreso());
        ed.setDuracion(unaEd.getDuracion());
        ed.setInstitucion(unaEd.getInstitucion());
        ed.setMateriasAprobadas(unaEd.getMateriasAprobadas());
        ed.setTitulo(unaEd.getTitulo());
        ed.setAnioFinalizacion(unaEd.getAnioFinalizacion());
        ed.setLogo(unaEd.getLogo());
        ed.setMateriasTotales(unaEd.getMateriasTotales());
        ed.setEstado(unaEd.getEstado());
        ed.setCertificado(unaEd.getCertificado());
        interEducacion.saveEducacion(ed);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/editar/eliminar/educacion/{id}")
    public void deleteEducacion(@PathVariable Long id){
        this.interEducacion.deleteEducacion(id);
    }
}
