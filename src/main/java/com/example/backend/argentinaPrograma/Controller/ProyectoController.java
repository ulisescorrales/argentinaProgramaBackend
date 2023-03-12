/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.Controller;

import com.example.backend.argentinaPrograma.Model.Proyecto;
import com.example.backend.argentinaPrograma.Service.IProyectoService;
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
public class ProyectoController {
    @Autowired
    private IProyectoService interProyecto;
    
   
    @GetMapping("/proyecto/traer")
    public List<Proyecto> getAllProyectos(){
        return interProyecto.getAllProyectos();
    }
    @GetMapping("/proyecto/traer/{id}")
    public Proyecto getProyecto(@PathVariable Long id){        
        return interProyecto.getProyecto(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/proyecto/agregar")
    public  void saveProyecto(@RequestBody Proyecto proyecto){
        interProyecto.saveProyecto(proyecto);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/proyecto/editar/{id}")
    public void putProyectyo(@PathVariable Long id,
            @RequestBody Proyecto proyecto){
        Proyecto p=interProyecto.getProyecto(id);
        
        p.setNombre(proyecto.getNombre());
        p.setDescripcion(proyecto.getDescripcion());
        p.setGithub(proyecto.getGithub());
        p.setLink(proyecto.getLink());
        p.setGithubBackEnd(proyecto.getGithubBackEnd());
        p.setGithubFrontEnd(proyecto.getGithubFrontEnd());
        p.setLogo(proyecto.getLogo());
        interProyecto.saveProyecto(p);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("editar/eliminar/proyecto/{id}")
    public void deleteProyecto(@PathVariable Long id){
        interProyecto.deleteProyecto(id);
    }
}
