
package com.example.AP.Sevices;

import com.example.AP.Entity.Proyecto;
import com.example.AP.Repository.ProyectoRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService {
    
@Autowired
    ProyectoRepo proyectoRepo;

    public List<Proyecto> list() {
        return proyectoRepo.findAll();
    }

    public Optional<Proyecto> getOne(int id) {
        return proyectoRepo.findById(id);
    }
    
    
    public Optional<Proyecto> getByTituloProyecto(String tituloProyecto) {
        return proyectoRepo.findByTituloProyecto(tituloProyecto);
    }

    public void save(Proyecto proy) {
        proyectoRepo.save(proy);
    }

    public void delete(int id) {
        proyectoRepo.deleteById(id);
    }

    public boolean existsById(int id) {
        return proyectoRepo.existsById(id);
    }
    
     public boolean existsByTituloProyecto(String tituloProyecto) {
        return proyectoRepo.existsByTituloProyecto(tituloProyecto);
    }

}

