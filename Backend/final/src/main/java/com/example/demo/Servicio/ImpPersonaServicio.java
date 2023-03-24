/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Entidad.Persona;
import com.example.demo.Interfas.IPersonaServicio;
import com.example.demo.Repositor.IPersonaRepositor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
