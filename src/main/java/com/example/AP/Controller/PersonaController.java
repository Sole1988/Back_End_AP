
package com.example.AP.Controller;

import com.example.AP.Entity.Persona;
import com.example.AP.Interface.IPersona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/persona")
public class PersonaController {
    
   @Autowired IPersona Ipersona;
   
   
    
@GetMapping("/traer")
    public List<Persona> getPersona(){
      return Ipersona.getPersona();
    }

   @PreAuthorize("hasRole ('ADMIN')")
    @PostMapping("/crear")
    public String createPersona (@RequestBody Persona persona){
        Ipersona.savePersona(persona);
        return "La persona fue creada con exito";
    }
    
    
     @PreAuthorize("hasRole ('ADMIN')")
    @DeleteMapping ("/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        Ipersona.deletePersona(id);
        return "La persona fue eliminada con exito";
    }
    
    
     @PreAuthorize("hasRole ('ADMIN')")
    @PutMapping("/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                                                @RequestParam ("apellido")String nuevoApellido,
                                                @RequestParam ("nombre")String nuevoNombre,
                                                @RequestParam ("titulo")String nuevoTitulo,
                                                @RequestParam ("descripcion")String nuevoDescripcion,
                                                @RequestParam ("imagen")String nuevoImagen){
    Persona persona = Ipersona.findPersona(id);
    
    persona.setNombre(nuevoNombre);
    persona.setApellido(nuevoTitulo);
    persona.setTitulo(nuevoTitulo);
    persona.setDescripcion(nuevoDescripcion);
    persona.setImagen(nuevoImagen);
    
    Ipersona.savePersona(persona);
    return persona;
                                                
    }
}
