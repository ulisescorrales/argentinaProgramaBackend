/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

/**
 *
 * @author Corrales Ulises
 */
@Entity
@Getter
@Setter
public class Educacion {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long idEstudio;
    private String titulo;
    private String logo;
    private String institucion;
    private int anioIngreso;
    private int anioFinalizacion;
    private int duracion;
    private int materiasAprobadas;
    private int materiasTotales;        
}
