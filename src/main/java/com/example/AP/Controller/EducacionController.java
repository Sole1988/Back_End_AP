
package com.example.AP.Controller;

import com.example.AP.Entity.Educacion;
import com.example.AP.Interface.IEducacion;


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
@RequestMapping("/educacion")
public class EducacionController {
   
    
   @Autowired IEducacion Ieducacion;
   
   
    
@GetMapping("/traer")
    public List<Educacion> getEducacion(){
      return Ieducacion.getEducacion();
    }

   
    @PostMapping("/crear")
    public String createEducacion (@RequestBody Educacion educacion){
        Ieducacion.saveEducacion(educacion);
        return "La educacion fue creada con exito";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String deleteEducacion(@PathVariable Long id){
        Ieducacion.deleteEducacion(id);
        return "La educacion fue eliminda con exito";
    }
    
    @PutMapping("/editar/{id}")
    public Educacion editEducacion(@PathVariable Long id,
                                                @RequestParam ("tituloEdu")String nuevoTituloEdu,
                                                @RequestParam ("fechaEdu")String nuevoFechaEdu,
                                                @RequestParam ("institutoEdu")String nuevoInstitutoEdu,
                                               @RequestParam ("imagenEdu")String nuevoImagenEdu){
   Educacion educacion = Ieducacion.findEducacion(id);
    
    educacion.setTituloEdu(nuevoTituloEdu);
   educacion.setFechaEdu(nuevoFechaEdu);
   educacion.setInstitutoEdu(nuevoInstitutoEdu);
   educacion.setImagenEdu(nuevoImagenEdu);
   
    Ieducacion.saveEducacion(educacion);
    return educacion;   
        
    }
}
    
    
    
    
    

