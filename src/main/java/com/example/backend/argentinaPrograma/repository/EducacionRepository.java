/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.backend.argentinaPrograma.repository;

import com.example.backend.argentinaPrograma.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Corrales Ulises
 */
public interface EducacionRepository extends JpaRepository<Educacion,Long> {
    
}
