/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.intento6.Repositor;

import com.portafolio.intento6.Entidad.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Simón
 */
@Repository
public interface IPersonaRepositor extends JpaRepository<Persona, Long>{
    
}
