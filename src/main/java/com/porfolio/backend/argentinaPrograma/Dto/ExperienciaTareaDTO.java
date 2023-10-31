/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.backend.argentinaPrograma.Dto;

import com.porfolio.backend.argentinaPrograma.Model.Tarea;
import java.sql.Date;

/**
 *
 * @author Corrales Ulises
 */
public class ExperienciaTareaDTO {
    private Long idExperiencia;
    private String organizacion;
    private String descripcion;
    private String logo;
    private Date inicio;
    private Date fin;    
    private Tarea[] tareas;
}
