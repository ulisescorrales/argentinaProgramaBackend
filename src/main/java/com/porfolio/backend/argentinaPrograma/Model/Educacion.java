/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.backend.argentinaPrograma.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import javax.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Corrales Ulises
 */
@Entity
@Getter @Setter
public class Educacion {

    @Id
   @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idEstudio;
    private String titulo;
    private String logo;
    private String institucion;
    @Nullable
    private String anioIngreso;
    private String anioFinalizacion;
    private String duracion;
    private Integer materiasAprobadas;
    private Integer materiasTotales;        
    private String estado;
    private String certificado;
}
