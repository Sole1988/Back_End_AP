
package com.example.AP.Sevices;

import com.example.AP.Entity.Proyectos;
import com.example.AP.Interface.IProyectos;
import com.example.AP.Repository.ProyectosRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ProyectosService implements IProyectos {
    
 @Autowired ProyectosRepo proyectosRepo;

    @Override
    public List<Proyectos> getProyectos() {
        List<Proyectos> proyectos = proyectosRepo.findAll();
        return proyectos;
    }

    @Override
    public void saveProyectos(Proyectos proyectos) {
        proyectosRepo.save(proyectos);
    }

    @Override
    public void deleteProyectos(Long id) {
        proyectosRepo.deleteById(id);
    }

    @Override
    public Proyectos findProyectos(Long id) {
        Proyectos proyectos = proyectosRepo.findById(id).orElseThrow(null);
        return proyectos;
    }

    
}
        
    

