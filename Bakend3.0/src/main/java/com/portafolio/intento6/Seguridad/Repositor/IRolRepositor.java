/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolio.intento6.Seguridad.Repositor;

import com.portafolio.intento6.Seguridad.Entidad.Rol;
import com.portafolio.intento6.Seguridad.Enuns.RolNombre;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Simón
 */
@Repository
public interface IRolRepositor extends JpaRepository<Rol, Integer> {
     Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
