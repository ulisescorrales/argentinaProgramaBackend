/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.backend.argentinaPrograma.Service;

import com.porfolio.backend.argentinaPrograma.Model.Educacion;
import com.porfolio.backend.argentinaPrograma.Repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Corrales Ulises
 */
@Service
public class EducacionService implements IEducacionService{
    @Autowired
    private EducacionRepository educacionRepository;
    @Override
    public List<Educacion> getEducacion(){
        List<Educacion> list=educacionRepository.findAll();
        return list;
    }
    @Override
    public void saveEducacion(Educacion e){
        educacionRepository.save(e);
    }
    @Override
    public Educacion findEducacion(Long id){
        return educacionRepository.findById(id).get();
    }
    @Override
    public void deleteEducacion(Long id){
        educacionRepository.deleteById(id);
    }
}
