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
@Entity
@Getter @Setter
public class Tecnologia {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long idTecnologia;
    private String nombre;
    private String logo;
}
