
package com.example.AP.Controller;

import com.example.AP.Entity.Skills;
import com.example.AP.Interface.ISkills;
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
@RequestMapping("/skills")
public class SkillsController {

    @Autowired ISkills Iskills;
    
  
    
@GetMapping("/traer")
        public List<Skills> getSkills(){
      return Iskills.getSkills();
    }

   
    @PostMapping("/crear")
    public String createSkills (@RequestBody Skills skills){
        Iskills.saveSkills(skills);
        return "La skills fue creada con exito";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String deleteSkills(@PathVariable Long id){
        Iskills.deleteSkills(id);
        return "La skills fue eliminada con exito";
    }
    
    @PutMapping("/editar/{id}")
    public Skills editSkills(@PathVariable Long id,
                                                @RequestParam ("nombreSkills")String nuevoNombreSkills,
                                                @RequestParam ("porcentajeSkills")String nuevoPorcentajeSkills,
                                                @RequestParam ("imagenSkills")String nuevoImagenSkills){
    Skills skills = Iskills.findSkills(id);
    
    skills.setNombreSkills(nuevoNombreSkills);
    skills.setPorcentajeSkills(id);
    skills.setImagenSkills(nuevoImagenSkills);   
   
    
    Iskills.saveSkills(skills);
    return skills;
                                                
    }
}

