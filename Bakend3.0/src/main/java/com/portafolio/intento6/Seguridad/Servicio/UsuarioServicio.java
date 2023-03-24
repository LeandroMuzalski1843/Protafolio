/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.intento6.Seguridad.Servicio;

import com.portafolio.intento6.Seguridad.Entidad.Usuario;
import com.portafolio.intento6.Seguridad.Repositor.IUsuarioRepositor;
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
public class UsuarioServicio {
    @Autowired
    IUsuarioRepositor iusuarioRepositor;
    
  public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
    return iusuarioRepositor.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
    return iusuarioRepositor.existsByNombreUsuario(nombreUsuario); 
    }
    
    public boolean existsByEmail(String email){
    return iusuarioRepositor.existesByEmail(email); 
    }
    
    public void save(Usuario usuario){
    iusuarioRepositor.save(usuario);
        
    }
    
}
