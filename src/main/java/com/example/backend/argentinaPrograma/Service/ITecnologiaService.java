/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.backend.argentinaPrograma.Service;

import com.example.backend.argentinaPrograma.Model.Tecnologia;
import java.util.List;

/**
 *
 * @author Corrales Ulises
 */
public interface ITecnologiaService {
    public List<Tecnologia> getTecnologia();
    public void saveTecnologia(Tecnologia e);
    public Tecnologia findTecnolgia(Long id);
    public void deleteTecnologia(Long id);
}
