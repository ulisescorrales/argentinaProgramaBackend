/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.Controller;

import com.example.backend.argentinaPrograma.Model.Tarea;
import com.example.backend.argentinaPrograma.Service.ITareaService;
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

    @GetMapping("/tarea/{idE}/tarea/traer")
    public List<Tarea> getTareas(@PathVariable Long idE) {
        return interTarea.getTarea(idE);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/tarea/agregar")
    public void putTarea(@RequestBody Tarea t) {
        interTarea.saveTarea(t);
    }   

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/tarea/editar/{id}")
    public void putTarea(@PathVariable Long id,
            @RequestParam String descripcion,
            @RequestParam String logo) {
        Tarea tarea = interTarea.findTarea(id);
        tarea.setDescripcion(descripcion);
        tarea.setRepositorio(descripcion);

        interTarea.saveTarea(tarea);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/editar/eliminar/tarea/{id}")
    public void deleteTarea(@PathVariable Long id){
        interTarea.deleteTarea(id);
    }
}
