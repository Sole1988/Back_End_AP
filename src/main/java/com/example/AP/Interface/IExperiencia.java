
package com.example.AP.Interface;

import com.example.AP.Entity.Experiencia;
import java.util.List;


public interface IExperiencia {
   
    //Traer una lista de personas

    public List<Experiencia> getExperiencia();

    //Guardar una persona
    public void saveExperiencia(Experiencia experiencia);

    //Eliminar una persona  por Id
    public void deleteExperiencia(Long id);

    //Buscar una persona por id
    public Experiencia findExperiencia(Long id);

}

