
package com.example.AP.Interface;

import com.example.AP.Entity.Skills;
import java.util.List;


public interface ISkills {
    
      //Traer una lista de personas
    public List<Skills> getSkills();
    
    //Guardar una persona
    public void saveSkills (Skills skills);
    
    //Eliminar una persona  por Id
    public void deleteSkills(Long id);
    
    //Buscar una persona por id
    public Skills findSkills(Long id);
    
            
}
