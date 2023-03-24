/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Seguridad.Control;

import com.example.demo.Seguridad.Dto.JwtDto;
import com.example.demo.Seguridad.Dto.LoginUsuario;
import com.example.demo.Seguridad.Dto.NuevoUsuario;
import com.example.demo.Seguridad.Entidad.Rol;
import com.example.demo.Seguridad.Entidad.Usuario;
import com.example.demo.Seguridad.Enuns.RolNombre;
import com.example.demo.Seguridad.Servicio.RolServicio;
import com.example.demo.Seguridad.Servicio.UsuarioServicio;
import com.example.demo.Seguridad.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Simón
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager ;
    @Autowired
    UsuarioServicio usuarioServicio;
    @Autowired
    RolServicio rolServicio;
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@ Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"),HttpStatus.BAD_REQUEST);
        if(usuarioServicio.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("Ese nombre de usuario ya existe"),HttpStatus.BAD_REQUEST);
        
        if(usuarioServicio.existsByNombreUsuario(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("Ese email ya existe"),HttpStatus.BAD_REQUEST);
        
        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
                nuevoUsuario.getEmail(),passwordEncoder.encode(nuevoUsuario.getContraseña()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolServicio.getByRolNombre(RolNombre.ROLE_USER).get());
        
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolServicio.getByRolNombre(RolNombre.ROLE_USER).get());
        usuario.setRoles(roles);
        usuarioServicio.save(usuario);
        
        return new ResponseEntity(new Mensaje("Usuario guardado"),HttpStatus.CREATED);
        
    }
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos"),HttpStatus.BAD_REQUEST);
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getContraseña()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(),
        userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
    
}
