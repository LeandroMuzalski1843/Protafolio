/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.intento6.Interfas;

import com.portafolio.intento6.Entidad.Persona;
import java.util.List;

/**
 *
 * @author Simón
 */
public interface IPersonaServicio {
    public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(Long id);
    
    public Persona findPersona(Long id);
}
