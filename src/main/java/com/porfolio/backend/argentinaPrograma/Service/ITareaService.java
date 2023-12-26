/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.backend.argentinaPrograma.Service;

import com.porfolio.backend.argentinaPrograma.Model.TareaExperiencia;
import com.porfolio.backend.argentinaPrograma.Model.TareaProyecto;
import java.util.List;

/**
 *
 * @author Corrales Ulises
 */
public interface ITareaService {    
    
    public List<TareaProyecto> getTareaProyecto(Long idP);
    public List<TareaExperiencia> getTareaExperiencia(Long idE);
    public void saveTareaProyecto(TareaProyecto t);
    public void saveTareaExperiencia(TareaExperiencia t);
    public TareaProyecto findTareaProyecto(Long id);
    public TareaExperiencia findTareaExperiencia(Long id);
    public void deleteTareaProyecto(Long id);
    public void deleteTareaExperiencia(Long id);
}
