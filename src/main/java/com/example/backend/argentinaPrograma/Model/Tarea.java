/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Corrales Ulises
 */
@Entity
@Getter @Setter
public class Tarea {
    @Id
    private Long id_tarea;
    private Long id_experiencia;
    private String titulo;
    private String descripcion;
    private String repositorio;
    @ManyToOne
    @JoinColumn(name="id_experiencia",nullable=false)
    private Experiencia experiencia;
}
