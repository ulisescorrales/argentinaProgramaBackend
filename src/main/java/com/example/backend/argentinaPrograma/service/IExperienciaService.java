/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.backend.argentinaPrograma.service;

import com.example.backend.argentinaPrograma.model.Experiencia;
import java.util.List;

/**
 *
 * @author Corrales Ulises
 */
public interface IExperienciaService {
    public List<Experiencia> getExperiencia();
    public void saveExperiencia(Experiencia exp);
    public Experiencia findExperiencia(Long id);
    public void deleteExperiencia(Long id);
}
