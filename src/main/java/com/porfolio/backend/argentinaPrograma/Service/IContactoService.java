/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.backend.argentinaPrograma.Service;

import com.porfolio.backend.argentinaPrograma.Model.Contacto;

/**
 *
 * @author Corrales Ulises
 */
public interface IContactoService {
    public Contacto traerContacto();
    public void saveContacto(Contacto contacto);
}
