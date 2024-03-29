/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.backend.argentinaPrograma.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Corrales Ulises
 */
@Entity
 @Getter  @Setter
public class Contacto {
    @Id
    private Long id_contacto;
    private String telefono;
    private String facebook;
    private String twitter;
    private String linkedin;
    private String email;
    private String github;
}
