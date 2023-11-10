/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.backend.argentinaPrograma.Service;


import com.porfolio.backend.argentinaPrograma.Model.Proyecto;
import java.util.List;

/**
 *
 * @author Corrales Ulises
 */
public interface IProyectoService {
    public List<Proyecto> getAllProyectos();
    public Proyecto getProyecto(Long id);
    public void deleteProyecto(Long id);
    public void saveProyecto(Proyecto proyecto);
}
