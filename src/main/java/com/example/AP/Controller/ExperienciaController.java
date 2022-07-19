
package com.example.AP.Controller;

import com.example.AP.Entity.Experiencia;
import com.example.AP.Interface.IExperiencia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/experiencia")
public class ExperienciaController {
    
    @Autowired IExperiencia Iexperiencia;
    
     @GetMapping("/traer")
    public List<Experiencia> getExperiencia(){
      return Iexperiencia.getExperiencia();
    }

   
    @PostMapping("/crear")
    public String createExperiencia (@RequestBody Experiencia experiencia){
        Iexperiencia.saveExperiencia(experiencia);
        return "La experiencia fue creada con exito";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String deleteExperiencia(@PathVariable Long id){
        Iexperiencia.deleteExperiencia(id);
        return "La experiencia fue eliminda con exito";
    }
    
    @PutMapping("/editar/{id}")
    public Experiencia editExperiencia(@PathVariable Long id,
                                                @RequestParam ("empresaExp")String nuevoEmpresaExp,
                                                @RequestParam ("fechaExp")String nuevoFechaExp,
                                               @RequestParam ("descripcionExp")String nuevoDescripcionExp,
                                                @RequestParam ("imagen")String nuevoImagenExp){
    Experiencia experiencia = Iexperiencia.findExperiencia(id);
    
  experiencia.setEmpresaExp(nuevoEmpresaExp);
  experiencia.setFechaExp(nuevoFechaExp);
  experiencia.setDescripcionExp(nuevoDescripcionExp);
  experiencia.setImagenExp(nuevoImagenExp);
    
    Iexperiencia.saveExperiencia(experiencia);
    return experiencia;
                                                
    }
}
    
    
    
    
    
    
    

