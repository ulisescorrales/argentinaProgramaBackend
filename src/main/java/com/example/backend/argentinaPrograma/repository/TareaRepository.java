/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.backend.argentinaPrograma.repository;

import com.example.backend.argentinaPrograma.model.Tarea;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Corrales Ulises
 */
public interface TareaRepository extends JpaRepository<Tarea,Long>{
   // @Query("SELECT * FROM (experiencia JOIN tarea) WHERE idExperiencia= :idExperiencia")
   // public List<Tarea> findJoinTarea(Long idExperiencia);
}
