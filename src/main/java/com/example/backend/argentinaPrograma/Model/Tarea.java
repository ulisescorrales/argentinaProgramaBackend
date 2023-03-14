/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idTarea;
    //private Long idExp;
    private String titulo;
    private String descripcion;
    private String repositorio;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="id_exp")
    private Experiencia experiencia;
}
