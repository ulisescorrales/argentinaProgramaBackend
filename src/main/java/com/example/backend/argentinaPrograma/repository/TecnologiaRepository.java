/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.backend.argentinaPrograma.Repository;

import com.example.backend.argentinaPrograma.Model.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Corrales Ulises
 */
@Repository
public interface TecnologiaRepository extends JpaRepository<Tecnologia,Long>{
    
}
