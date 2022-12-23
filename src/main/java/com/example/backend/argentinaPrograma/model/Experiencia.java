/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Corrales Ulises
 */
@Entity
@Getter @Setter
public class Experiencia {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long idExperiencia;
    private String organizacion;
    private Date inicio;
    private Date fin;
    private String descripcion;
    private String logo;
}