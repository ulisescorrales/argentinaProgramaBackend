/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.service;

import com.example.backend.argentinaPrograma.model.Contacto;
import com.example.backend.argentinaPrograma.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Corrales Ulises
 */
@Service
public class ContactoService implements IContactoService{
    @Autowired
    private ContactoRepository contactoRepository;
    
    @Override
    public Contacto traerContacto(){
        return contactoRepository.findById(Long.valueOf(1)).get();
    }
    @Override
    public void saveContacto(Contacto contacto){
        contactoRepository.save(contacto);
    }
}
