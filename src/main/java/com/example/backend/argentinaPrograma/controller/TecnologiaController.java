/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.Controller;

import com.example.backend.argentinaPrograma.Model.Tecnologia;
import com.example.backend.argentinaPrograma.Service.ITecnologiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TecnologiaController {
    @Autowired
    private ITecnologiaService interTecnologia;
    
    @GetMapping("/tecnologia/traer")
    public List<Tecnologia> getEducation() {
        return interTecnologia.getTecnologia();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/tecnologia/agregar")
    public void putEducacion(@RequestBody Tecnologia ed) {
        interTecnologia.saveTecnologia(ed);
    }

    @GetMapping("/tecnologia/traer/{id}")
    public Tecnologia finTecnologia(@PathVariable Long id) {
        return interTecnologia.findTecnolgia(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/tecnologia/editar/{id}")
    public void modificarTecnologia(@PathVariable Long id,
            @RequestBody Tecnologia unaTecnologia){
        Tecnologia tec=interTecnologia.findTecnolgia(id);
        tec.setLogo(unaTecnologia.getLogo());
        tec.setNombre(unaTecnologia.getNombre());
        
        interTecnologia.saveTecnologia(tec);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/editar/eliminar/conocimiento/{id}")
    public void deleteTecnologia(@PathVariable Long id){
        this.interTecnologia.deleteTecnologia(id);
    }
}
