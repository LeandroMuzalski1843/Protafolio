/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Seguridad.Servicio;

import com.example.demo.Seguridad.Entidad.Usuario;
import com.example.demo.Seguridad.Entidad.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Simón
 */
@Service
public class UserDetailsImpl implements UserDetailsService {
    @Autowired
    UsuarioServicio usuarioServicio;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioServicio.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuario);
    }
    
}
