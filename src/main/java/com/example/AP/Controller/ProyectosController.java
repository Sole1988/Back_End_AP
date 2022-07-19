
package com.example.AP.Controller;

import com.example.AP.Entity.Proyectos;
import com.example.AP.Interface.IProyectos;
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
@RequestMapping("/proyectos")
public class ProyectosController {
    
    @Autowired IProyectos Iproyectos;
            
    @GetMapping("/traer")
    public List<Proyectos> getProyectos(){
      return Iproyectos.getProyectos();
    }

   
    @PostMapping("/crear")
    public String createPrpyectos (@RequestBody Proyectos proyectos){
        Iproyectos.saveProyectos(proyectos);
        return "El proyecto fue creado con exito";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String deleteProyectos(@PathVariable Long id){
        Iproyectos.deleteProyectos(id);
        return "El proyecto fue eliminado con exito";
    }
    
    @PutMapping("/editar/{id}")
    public Proyectos editProyectos(@PathVariable Long id,
                                                @RequestParam ("tituloProyecto")String nuevoTituloProyecto,
                                                @RequestParam ("fechaProyecto")String nuevoFechaProyecto,
                                                @RequestParam ("descripcionProyecto")String nuevoDescripcionProyecto){
    Proyectos proyectos = Iproyectos.findProyectos(id);
    
   proyectos.setTituloProyecto(nuevoTituloProyecto);
   proyectos.setFechaProyecto(nuevoFechaProyecto);
   proyectos.setDescripcionProyecto(nuevoDescripcionProyecto);
    
    Iproyectos.saveProyectos(proyectos);
    return proyectos;
                                                
    }
   
    }
    
