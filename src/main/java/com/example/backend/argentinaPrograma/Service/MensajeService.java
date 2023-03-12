/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backend.argentinaPrograma.Service;

import com.example.backend.argentinaPrograma.Model.Mensaje;
import com.example.backend.argentinaPrograma.Repository.MensajeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Corrales Ulises
 */
@Service
public class MensajeService implements IMensajeService{
    @Autowired
    private MensajeRepository mensajeRepository;

    @Override
    public List<Mensaje> getMensajes() {
        List<Mensaje> lista=mensajeRepository.findAll();
        return lista;
    }

    @Override
    public void saveMensaje(Mensaje mensaje) {
        mensajeRepository.save(mensaje);
    }

    @Override
    public void deleteMensaje(Long id) {
        mensajeRepository.deleteById(id);
    }

    @Override
    public Mensaje findMensaje(Long id) {
        Mensaje mensaje=mensajeRepository.findById(id).orElse(null);
        return mensaje;
    }
        
}
