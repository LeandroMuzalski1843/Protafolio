/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.intento6.Servicio;

import com.portafolio.intento6.Entidad.Persona;
import com.portafolio.intento6.Interfas.IPersonaServicio;
import com.portafolio.intento6.Repositor.IPersonaRepositor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Simón
 */
@Service
public class ImpPersonaServicio implements IPersonaServicio{

    @Autowired IPersonaRepositor ipersonaRepositor;
    
    @Override
    public List<Persona> getPersona() {
       List<Persona> persona = ipersonaRepositor.findAll();
       return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepositor.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepositor.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepositor.findById(id).orElse(null);
        return persona;
    }
    
}
