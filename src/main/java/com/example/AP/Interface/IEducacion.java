
package com.example.AP.Interface;

import com.example.AP.Entity.Educacion;
import java.util.List;


public interface IEducacion {
     //Traer una lista de personas

    public List<Educacion> getEducacion();

    //Guardar una persona
    public void saveEducacion(Educacion educacion);

    //Eliminar una persona  por Id
    public void deleteEducacion(Long id);

    //Buscar una persona por id
    public Educacion findEducacion(Long id);

}
