/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Seguridad.Servicio;

import com.example.demo.Seguridad.Entidad.Rol;
import com.example.demo.Seguridad.Enuns.RolNombre;
import com.example.demo.Seguridad.Repositor.iRolRepositor;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolServicio {
    @Autowired
    iRolRepositor irolRepositor;
    public Optional<Rol>getByRolNombre(RolNombre rolNombre){
        return irolRepositor.findByRolNombre(rolNombre);
    }
    public void save(Rol rol){
        irolRepositor.save(rol);
    }
}
