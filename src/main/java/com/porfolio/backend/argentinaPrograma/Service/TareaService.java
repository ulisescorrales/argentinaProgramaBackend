/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.backend.argentinaPrograma.Service;

import com.porfolio.backend.argentinaPrograma.Model.Tarea;
import com.porfolio.backend.argentinaPrograma.Repository.TareaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Corrales Ulises
 */
@Service
public class TareaService implements ITareaService{    
    @Autowired
    private TareaRepository tareaRepository;
    
    @Override
    public List<Tarea> getTarea(Long idExperiencia){
        return tareaRepository.findAll();//tareaRepository.findJoinTarea(idExperiencia);
    }
    @Override
    public void saveTarea(Tarea t){
        tareaRepository.save(t);
    };
    @Override
    public Tarea findTarea(Long id){
        return tareaRepository.findById(id).get();
    }
    @Override
    public void deleteTarea(Long id){
        tareaRepository.deleteById(id);
    }
}
