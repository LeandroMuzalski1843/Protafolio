/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Control;

import com.example.demo.Entidad.Persona;
import com.example.demo.Interfas.IPersonaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class PersonaControl {
    @Autowired IPersonaServicio ipersonaServicio;
    
    @GetMapping("personas/traer")
    public List<Persona> getPersona(){
        return ipersonaServicio.getPersona();
    }
    
    @PostMapping("/persona/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaServicio.savePersona(persona);
        return "la persona fue creada";
    }
    
    @DeleteMapping("/personas/borrar/(id)")
    public String deletePersona(@PathVariable Long id){
        ipersonaServicio.deletePersona(id);
        return "la persona fue eliminada";
    }
    
    @PostMapping("/personas/editar/(id)")
    public Persona editPersona(@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("img") String nuevoImg){
         Persona persona = ipersonaServicio.findPersona(id);
         
         persona.setNombre(nuevoNombre);
         persona.setApellido(nuevoApellido);
         persona.setImg(nuevoImg);
         
         ipersonaServicio.savePersona(persona);
         return persona;
    }
    @GetMapping("personas/crear/perfil")
    public Persona findPersona(){
        return ipersonaServicio.findPersona((long)1);
    }
}
 