
package com.example.AP.Interface;

import com.example.AP.Entity.Persona;
import java.util.List;


public interface IPersona {
    
    //Traer una lista de personas
    public List<Persona> getPersona();
    
    //Guardar una persona
    public void savePersona (Persona persona);
    
    //Eliminar una persona  por Id
    public void deletePersona(Long id);
    
    //Buscar una persona por id
    public Persona findPersona(Long id);
    
            
}
