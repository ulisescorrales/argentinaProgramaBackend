/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.backend.argentinaPrograma.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;


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
    private Long idExperiencia;
    private String titulo;
    private String organizacion;
    private String descripcion;
    private String logo;
    private String inicio;
    private String fin;       
    @OneToMany(cascade = CascadeType.ALL,mappedBy="experiencia")    
    private List<TareaExperiencia> tareas;
}