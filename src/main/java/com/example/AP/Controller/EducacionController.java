
package com.example.AP.Controller;


import com.example.AP.Dto.DtoEducacion;
import com.example.AP.Entity.Educacion;
import com.example.AP.Security.Controller.Mensaje;
import com.example.AP.Sevices.EducacionService;
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
@RequestMapping("/educ")
@CrossOrigin(origins = "https://apmattosfront-b1f8a.web.app")        
public class EducacionController {
    
    @Autowired
    EducacionService educacionService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = educacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        if (!educacionService.existsById(id)) 
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        
        Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

 
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!educacionService.existsById(id)) 
            return new ResponseEntity(new Mensaje("Esta educacion no existe"), HttpStatus.NOT_FOUND);
        
        educacionService.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoedu) {
        if (StringUtils.isBlank(dtoedu.getTituloEdu())) 
            return new ResponseEntity(new Mensaje("El dato es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if (educacionService.existsByTituloEdu(dtoedu.getTituloEdu())) 
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
       Educacion educacion = new Educacion(dtoedu.getTituloEdu(), dtoedu.getFechaEdu(), dtoedu.getDescripcionEdu(), dtoedu.getInstitutoEdu(), dtoedu.getImagenEdu());
        educacionService.save(educacion);

        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoedu) {

        if (!educacionService.existsById(id)) 
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if (educacionService.existsByTituloEdu(dtoedu.getTituloEdu()) && educacionService.getByTituloEdu(dtoedu.getTituloEdu()).get().getId() != id) 
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        

        if (StringUtils.isBlank(dtoedu.getTituloEdu())) 
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        

        Educacion educacion = educacionService.getOne(id).get();
       educacion.setTituloEdu(dtoedu.getTituloEdu());
       educacion.setFechaEdu(dtoedu.getFechaEdu());
       educacion.setDescripcionEdu(dtoedu.getDescripcionEdu());
       educacion.setInstitutoEdu(dtoedu.getInstitutoEdu());
       educacion.setImagenEdu(dtoedu.getImagenEdu());
        

        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}

    
    
    
    
    
    

