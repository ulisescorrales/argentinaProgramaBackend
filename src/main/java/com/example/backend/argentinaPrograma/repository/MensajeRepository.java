/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.repository;

import com.example.backend.argentinaPrograma.model.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Corrales Ulises
 */
public interface MensajeRepository extends JpaRepository<Mensaje,Long>{
    
}
