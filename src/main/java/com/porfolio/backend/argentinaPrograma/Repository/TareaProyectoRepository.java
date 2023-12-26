/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.backend.argentinaPrograma.Repository;

import com.porfolio.backend.argentinaPrograma.Model.TareaProyecto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ulisescorrales
 */
@Repository
public interface TareaProyectoRepository extends JpaRepository<TareaProyecto,Long> {
    
    public List<TareaProyecto> findByProyectoIdProyecto(Long idP);
}
