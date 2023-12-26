/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.backend.argentinaPrograma.Service;

import com.porfolio.backend.argentinaPrograma.Model.TareaExperiencia;
import com.porfolio.backend.argentinaPrograma.Model.TareaProyecto;
import com.porfolio.backend.argentinaPrograma.Repository.TareaExperienciaRepository;
import com.porfolio.backend.argentinaPrograma.Repository.TareaProyectoRepository;
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
    private TareaExperienciaRepository teRepository;
    @Autowired
    private TareaProyectoRepository tpRepository;

    @Override
    public List<TareaProyecto> getTareaProyecto(Long idP) {
        return this.tpRepository.findByProyectoIdProyecto(idP);
    }

    @Override
    public List<TareaExperiencia> getTareaExperiencia(Long idTE) {
        return this.teRepository.findByExperienciaIdExperiencia(idTE);
    }

    @Override
    public void saveTareaProyecto(TareaProyecto t) {
        this.tpRepository.save(t);
    }

    @Override
    public void saveTareaExperiencia(TareaExperiencia t) {
        this.teRepository.save(t);
    }

    @Override
    public TareaProyecto findTareaProyecto(Long id) {
        return this.tpRepository.findById(id).get();
    }

    @Override
    public TareaExperiencia findTareaExperiencia(Long id) {
        return this.teRepository.findById(id).get();
    }

    @Override
    public void deleteTareaProyecto(Long id) {
        this.tpRepository.deleteById(id);
    }

    @Override
    public void deleteTareaExperiencia(Long id) {
        this.teRepository.deleteById(id);
    }
    
}
