/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.backend.argentinaPrograma.Repository;

import com.porfolio.backend.argentinaPrograma.Model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Corrales Ulises
 */
@Repository
public interface TareaRepository extends JpaRepository<Tarea,Long>{
   // @Query("SELECT * FROM (experiencia JOIN tarea) WHERE idExperiencia= :idExperiencia")
   // public List<Tarea> findJoinTarea(Long idExperiencia);
}
