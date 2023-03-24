/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.intento6.Seguridad.Servicio;

import com.portafolio.intento6.Seguridad.Entidad.Rol;
import com.portafolio.intento6.Seguridad.Enuns.RolNombre;
import com.portafolio.intento6.Seguridad.Repositor.IRolRepositor;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Simón
 */
@Service
@Transactional
public class RolServicio {
     @Autowired
    IRolRepositor irolRepositor;
    public Optional<Rol>getByRolNombre(RolNombre rolNombre){
        return irolRepositor.findByRolNombre(rolNombre);
    }
    public void save(Rol rol){
        irolRepositor.save(rol);
    }
}
