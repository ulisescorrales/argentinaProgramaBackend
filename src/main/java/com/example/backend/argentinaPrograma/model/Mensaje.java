/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Corrales Ulises
 */
@Getter @Setter
@Entity
public class Mensaje {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idMensaje;
    private String organizacion;    
    private String contacto;    
    private String mensaje;

   
    
    
}
