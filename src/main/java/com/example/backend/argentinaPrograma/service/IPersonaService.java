/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.backend.argentinaPrograma.service;

import com.example.backend.argentinaPrograma.model.Persona;

/**
 *
 * @author Corrales Ulises
 */
public interface IPersonaService {
    public Persona getPersona();
    public void savePersona(Persona pers);
}
