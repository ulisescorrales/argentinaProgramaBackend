/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.Service;

import com.example.backend.argentinaPrograma.Model.Tecnologia;
import com.example.backend.argentinaPrograma.Repository.TecnologiaRepository;
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
