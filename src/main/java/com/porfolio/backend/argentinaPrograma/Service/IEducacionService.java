/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.backend.argentinaPrograma.Service;

import com.porfolio.backend.argentinaPrograma.Model.Educacion;
import java.util.List;

/**
 *
 * @author Corrales Ulises
 */
public interface IEducacionService {
    public List<Educacion> getEducacion();
    public void saveEducacion(Educacion e);
    public Educacion findEducacion(Long id);
    public void deleteEducacion(Long id);
}
