/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.Controller;

import com.example.backend.argentinaPrograma.Repository.Proyecto;
import com.example.backend.argentinaPrograma.Service.IProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Corrales Ulises
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProyectoController {
    @Autowired
    private IProyectoService interProyecto;
    
   
    @GetMapping("/proyecto/traer")
    public List<Proyecto> getAllProyectos(){
        return interProyecto.getAllProyectos();
    }
    @GetMapping("/proyecto/{id}")
    public Proyecto getProyecto(@RequestParam Long id){
        return interProyecto.getProyecto(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/proyecto/agregar")
    public  void saveProyecto(@RequestBody Proyecto proyecto){
        interProyecto.saveProyecto(proyecto);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/proyecto/editar/{id}")
    public void putProyectyo(@RequestParam Long id,
            @RequestBody Proyecto proyecto){
        Proyecto p=interProyecto.getProyecto(id);
        
        p.setNombre(proyecto.getNombre());
        p.setDescripcion(proyecto.getDescripcion());
        p.setGithub(proyecto.getGithub());
        p.setLink(proyecto.getLink());
        p.setGithubBackend(proyecto.getGithubBackend());
        p.setGithubFrontEnd(proyecto.getGithubFrontEnd());
        
        interProyecto.saveProyecto(p);
    }
}
