
package com.example.AP.Interface;

import com.example.AP.Entity.Proyectos;
import java.util.List;


public interface IProyectos {
    
      //Traer una lista de personas
    public List<Proyectos> getProyectos();
    
    //Guardar una persona
    public void saveProyectos (Proyectos proyectos);
    
    //Eliminar una persona  por Id
    public void deleteProyectos(Long id);
    
    //Buscar una persona por id
    public Proyectos findProyectos(Long id);
    
            
}
