/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.backend.argentinaPrograma.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Corrales Ulises
 */
@Getter @Setter
@Entity
public class Persona {
    @Id
    private Long idPersona;    
    private String nombre;        
    private String apellido;    
    private String fechaNac;    
    private String nacionalidad;
    private String sobreMi;
    private String fotoPerfil;
    private String fotoFondo;    
}
