/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.controller;

import com.example.backend.argentinaPrograma.model.Tecnologia;
import com.example.backend.argentinaPrograma.service.ITecnologiaService;
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
public class TecnologiaController {
    @Autowired
    private ITecnologiaService interTecnologia;
    
    @GetMapping("/tecnologia/traer")
    public List<Tecnologia> getEducation() {
        return interTecnologia.getTecnologia();
    }

    @PostMapping("/tecnologia/agregar")
    public void putEducacion(Tecnologia ed) {
        interTecnologia.saveTecnologia(ed);
    }

    @GetMapping("/tecnologia/{id}")
    public Tecnologia finTecnologia(@PathVariable Long id) {
        return interTecnologia.findTecnolgia(id);
    }

    @PutMapping("/tecnologia/editar/{id}")
    public void modificarTecnologia(@PathVariable Long id,
            @RequestParam String nombre,
            @RequestParam String logo){
        Tecnologia tec=interTecnologia.findTecnolgia(id);
        tec.setLogo(logo);
        tec.setDescripcion(logo);
    }
}
