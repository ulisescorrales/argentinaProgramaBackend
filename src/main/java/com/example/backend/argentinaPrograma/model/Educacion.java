/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Corrales Ulises
 */
@Entity
@Getter
@Setter
public class Educacion {

    @Id
    private long idEstudios;
    private String titulo;
    private String logo;
    private String institucion;
    private int anioIngreso;
    private int anioFinalizacion;
    private int duracion;
    private int materiasAprobadas;
}
