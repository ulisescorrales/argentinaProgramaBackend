/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.porfolio.backend.argentinaPrograma.Repository;

import com.porfolio.backend.argentinaPrograma.Model.TareaExperiencia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ulisescorrales
 */
@Repository
public interface TareaExperienciaRepository extends JpaRepository<TareaExperiencia,Long> {
    public List<TareaExperiencia> findByExperienciaIdExperiencia(Long idP);
}
