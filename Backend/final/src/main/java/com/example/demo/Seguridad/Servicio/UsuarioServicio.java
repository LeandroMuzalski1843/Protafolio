/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Seguridad.Servicio;


import com.example.demo.Seguridad.Entidad.Usuario;
import com.example.demo.Seguridad.Repositor.iUsuarioRepositor;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioServicio {
    @Autowired
    iUsuarioRepositor iusuarioRepositor;
    
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
