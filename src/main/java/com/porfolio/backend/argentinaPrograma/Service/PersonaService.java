/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.backend.argentinaPrograma.Service;

import com.porfolio.backend.argentinaPrograma.Model.Persona;
import com.porfolio.backend.argentinaPrograma.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Corrales Ulises
 */
@Service
public class PersonaService implements IPersonaService{
    @Autowired
    private PersonaRepository personaRepository;
    
    @Override
    public Persona getPersona(){        
        return personaRepository.findById(Long.valueOf(3)).get();
    }
    @Override
    public void savePersona(Persona pers){
        this.personaRepository.save(pers);
    }
}
