/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.backend.argentinaPrograma.Controller;

import com.porfolio.backend.argentinaPrograma.Model.Proyecto;
import com.porfolio.backend.argentinaPrograma.Model.TareaExperiencia;
import com.porfolio.backend.argentinaPrograma.Model.TareaProyecto;
import com.porfolio.backend.argentinaPrograma.Service.IProyectoService;
import com.porfolio.backend.argentinaPrograma.Service.ITareaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Corrales Ulises
 */
@RestController
public class TareaController {

    @Autowired
    private ITareaService interTarea;      
    @Autowired
    private IProyectoService interProyecto;
    
    @GetMapping("/tarea/{idE}/tareaExperiencia/traer")
    public List<TareaExperiencia> getTareaExperiencias(@PathVariable Long idE) {
        return interTarea.getTareaExperiencia(idE);
    }
    @GetMapping("/tarea/{idP}/tareaProyecto/traer")
    public List<TareaProyecto> getTareaProyectos(@PathVariable Long idP) {
        return interTarea.getTareaProyecto(idP);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/tareaExperiencia/agregar")
    public void putTarea(@RequestBody TareaExperiencia t) {
        interTarea.saveTareaExperiencia(t);
    }   
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/tareaProyecto/agregar/{idProyecto}")
    public List<TareaProyecto> putTarea(@RequestBody TareaProyecto t,@PathVariable Long idProyecto) {
        
        Proyecto p=interProyecto.getProyecto(idProyecto);
        t.setProyecto(p);
        interTarea.saveTareaProyecto(t);
        return p.getTareas();
    }  

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/tareaExperiencia/editar/{id}")
    public void putTareaExperiencia(@PathVariable Long id,
            @RequestParam String descripcion,
            @RequestParam String logo,
            @RequestParam String repositorio) {
        TareaExperiencia tarea = interTarea.findTareaExperiencia(id);
        tarea.setDescripcion(descripcion);
        tarea.setRepositorio(repositorio);

        interTarea.saveTareaExperiencia(tarea);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/tareaProyecto/editar/{id}")
    public void putTareaProyecto(@PathVariable Long id,
            @RequestParam String descripcion,
            @RequestParam String logo) {
        TareaProyecto tarea = interTarea.findTareaProyecto(id);
        tarea.setDescripcion(descripcion);
        tarea.setRepositorio(descripcion);

        interTarea.saveTareaProyecto(tarea);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/editar/eliminar/tareaExperiencia/{id}")
    public void deleteTareaExperiencia(@PathVariable Long id){
        interTarea.deleteTareaExperiencia(id);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/editar/eliminar/tareaProyecto/{id}")
    public void deleteTareaProyecto(@PathVariable Long id){                
        interTarea.deleteTareaProyecto(id);
    }
}
