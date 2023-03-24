/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolio.intento6.Seguridad.jwt;

import com.portafolio.intento6.Seguridad.Entidad.UsuarioPrincipal;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 *
 * @author Simón
 */
@Component
public class JwtProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("$(jwt.secret)")
    private String secret;
    @Value("$(jwt.expiration)")
    private int expiration;

    public String generateToken(Authentication authentication) {
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public String getNombreUsuarioFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("el token esta mal formado");
        } catch (UnsupportedJwtException e) {
            logger.error("token no lo soporto");
        } catch (ExpiredJwtException e) {
            logger.error("expiro el token");
        } catch (IllegalArgumentException e) {
            logger.error("token vacio");
        } catch (SignatureException e) {
            logger.error("firma invalida");
        }
        return false;
    }
}
