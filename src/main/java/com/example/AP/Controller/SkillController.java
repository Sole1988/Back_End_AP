
package com.example.AP.Controller;

import com.example.AP.Dto.DtoSkill;
import com.example.AP.Entity.Skill;
import com.example.AP.Security.Controller.Mensaje;
import com.example.AP.Sevices.SkillService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = "http://localhost:4200")      

public class SkillController {
    
 @Autowired
    SkillService skillService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list() {
        List<Skill> list = skillService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id) {
        if (!skillService.existsById(id)) 
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        
        Skill skill = skillService.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }

 
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!skillService.existsById(id)) 
            return new ResponseEntity(new Mensaje("Esta skill no existe"), HttpStatus.NOT_FOUND);
        
        skillService.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSkill dtoskill) {
        if (StringUtils.isBlank(dtoskill.getNombreSkill())) 
            return new ResponseEntity(new Mensaje("El dato es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if (skillService.existsByNombreSkill(dtoskill.getNombreSkill())) 
            return new ResponseEntity(new Mensaje("Esa skill existe"), HttpStatus.BAD_REQUEST);
        
      Skill skill = new Skill(dtoskill.getNombreSkill(),dtoskill.getPorcentajeSkill(), dtoskill.getImagenSkill());
        skillService.save(skill);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkill dtoskill) {

        if (!skillService.existsById(id)) 
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if (skillService.existsByNombreSkill(dtoskill.getNombreSkill()) && skillService.getByNombreSkill(dtoskill.getNombreSkill()).get().getId() != id) 
            return new ResponseEntity(new Mensaje("Esta skill ya existe"), HttpStatus.BAD_REQUEST);
        

        if (StringUtils.isBlank(dtoskill.getNombreSkill())) 
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        

        Skill skill = skillService.getOne(id).get();
       skill.setNombreSkill(dtoskill.getNombreSkill());
       skill.setPorcentajeSkill(dtoskill.getPorcentajeSkill());
       skill.setImagenSkill(dtoskill.getImagenSkill());
       
        
        skillService.save(skill);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }
}

    
