/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.Service;

import com.example.backend.argentinaPrograma.Model.Domicilio;
import com.example.backend.argentinaPrograma.Repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Corrales Ulises
 */
@Service
public class DomicilioService implements IDomicilioService{
    @Autowired
    private DomicilioRepository domicilioRepository;
    
    public Domicilio getDomicilio(){
        return domicilioRepository.findById(Long.valueOf(1)).get();
    }
    public void saveDomicilio(Domicilio dom){
       domicilioRepository.save(dom);
    }
}
