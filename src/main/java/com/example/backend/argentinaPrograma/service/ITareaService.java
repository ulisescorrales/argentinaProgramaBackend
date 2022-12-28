/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.backend.argentinaPrograma.Service;

import com.example.backend.argentinaPrograma.Model.Tarea;
import java.util.List;

/**
 *
 * @author Corrales Ulises
 */
public interface ITareaService {
    public List<Tarea> getTarea(Long idExp);
    public void saveTarea(Tarea t);
    public Tarea findTarea(Long id);
    public void deleteTarea(Long id);
}
