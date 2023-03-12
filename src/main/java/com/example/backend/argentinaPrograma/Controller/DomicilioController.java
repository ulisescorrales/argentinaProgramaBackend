/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.Controller;

import com.example.backend.argentinaPrograma.Model.Domicilio;
import com.example.backend.argentinaPrograma.Service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Corrales Ulises
 */
@RestController
public class DomicilioController {
    @Autowired        
    private IDomicilioService interDomicilio;
    
    @GetMapping("/domicilio/traer")
    public Domicilio getDomicilio(){
        return interDomicilio.getDomicilio();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/domicilio/editar")
    public void saveDomicilio(@RequestBody Domicilio dom){
        Domicilio unDom=interDomicilio.getDomicilio();
        
        unDom.setCalle(dom.getCalle());
        unDom.setCiudad(dom.getCiudad());
        unDom.setCodigoPostal(dom.getCodigoPostal());
        unDom.setNumero(dom.getNumero());
        unDom.setPais(dom.getPais());
        unDom.setProvincia(dom.getProvincia());        
        
        interDomicilio.saveDomicilio(unDom);
    }
}
