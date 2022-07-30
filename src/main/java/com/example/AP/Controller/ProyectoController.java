
package com.example.AP.Controller;


import com.example.AP.Dto.DtoProyecto;
import com.example.AP.Entity.Proyecto;
import com.example.AP.Security.Controller.Mensaje;
import com.example.AP.Sevices.ProyectoService;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "https://apmattosfront-b1f8a.web.app") 
public class ProyectoController {
    
@Autowired
    ProyectoService proyectoService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = proyectoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {
        if (!proyectoService.existsById(id)) 
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        
        Proyecto proyecto = proyectoService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

 
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!proyectoService.existsById(id)) 
            return new ResponseEntity(new Mensaje("Este dato no existe"), HttpStatus.NOT_FOUND);
        
        proyectoService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminad"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoproy) {
        if (StringUtils.isBlank(dtoproy.getTituloProyecto())) 
            return new ResponseEntity(new Mensaje("El dato es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if (proyectoService.existsByTituloProyecto(dtoproy.getTituloProyecto())) 
            return new ResponseEntity(new Mensaje("El proyecto ya existe"), HttpStatus.BAD_REQUEST);
        
       Proyecto proyecto = new Proyecto(dtoproy.getTituloProyecto(), dtoproy.getFechaProyecto(), dtoproy.getDescripcionProyecto());
        proyectoService.save(proyecto);

        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoproy) {

        if (!proyectoService.existsById(id)) 
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if (proyectoService.existsByTituloProyecto(dtoproy.getTituloProyecto()) && proyectoService.getByTituloProyecto(dtoproy.getTituloProyecto()).get().getId() != id) 
            return new ResponseEntity(new Mensaje("El proyecto ya existe"), HttpStatus.BAD_REQUEST);
        

        if (StringUtils.isBlank(dtoproy.getTituloProyecto())) 
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        

        Proyecto proyecto = proyectoService.getOne(id).get();
       proyecto.setTituloProyecto(dtoproy.getTituloProyecto());
       proyecto.setFechaProyecto(dtoproy.getFechaProyecto());
       proyecto.setDescripcionProyecto(dtoproy.getDescripcionProyecto());
     
        

        proyectoService.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
}

