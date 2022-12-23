/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.service;

import com.example.backend.argentinaPrograma.model.Experiencia;
import com.example.backend.argentinaPrograma.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Corrales Ulises
 */
@Service
public class ExperienciaService implements IExperienciaService{
    @Autowired
    private ExperienciaRepository experienciaRepository;
    
    @Override
    public List<Experiencia> getExperiencia(){
        return experienciaRepository.findAll();
    }
    @Override
    public void saveExperiencia(Experiencia exp){
        experienciaRepository.save(exp);
    }
    @Override
    public Experiencia findExperiencia(Long id){
        return experienciaRepository.findById(id).get();
    }
    @Override
    public void deleteExperiencia(Long id){
        experienciaRepository.deleteById(id);
    }
}
