/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.backend.argentinaPrograma.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ulisescorrales
 */
@Entity
@Getter
@Setter
public class TareaProyecto extends Tarea{
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="id_proyecto")
    private Proyecto proyecto;
    @Column(name="certificado")
    private String certificado;
}
