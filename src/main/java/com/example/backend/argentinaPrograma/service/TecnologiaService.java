/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.service;

import com.example.backend.argentinaPrograma.model.Tecnologia;
import com.example.backend.argentinaPrograma.repository.TecnologiaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Corrales Ulises
 */
@Service
public class TecnologiaService implements ITecnologiaService{
    @Autowired
    private TecnologiaRepository tecnologiaRepository;
    public List<Tecnologia> getTecnologia(){
        return tecnologiaRepository.findAll();
    }
    public void saveTecnologia(Tecnologia e){
        tecnologiaRepository.save(e);
    }
    public Tecnologia findTecnolgia(Long id){
        return tecnologiaRepository.findById(id).get();
    }
    public void deleteTecnologia(Long id){
        tecnologiaRepository.deleteById(id);
    }
}
