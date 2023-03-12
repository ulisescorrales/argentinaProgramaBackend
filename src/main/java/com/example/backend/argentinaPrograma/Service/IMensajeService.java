/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.Service;

import com.example.backend.argentinaPrograma.Model.Mensaje;
import java.util.List;

/**
 *
 * @author Corrales Ulises
 */
public interface IMensajeService {
    public List<Mensaje> getMensajes();
    public void saveMensaje(Mensaje mensaje);
    public void deleteMensaje(Long id);
    public Mensaje findMensaje(Long id);
}
