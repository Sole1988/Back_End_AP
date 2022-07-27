
package com.example.AP.Sevices;

import com.example.AP.Entity.Educacion;
import com.example.AP.Repository.EducacionRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class EducacionService {

    @Autowired
    EducacionRepo educacionRepo;

    public List<Educacion> list() {
        return educacionRepo.findAll();
    }

    public Optional<Educacion> getOne(int id) {
        return educacionRepo.findById(id);
    }
    
    
    public Optional<Educacion> getByTituloEdu(String tituloEdu) {
        return educacionRepo.findByTituloEdu(tituloEdu);
    }

    public void save(Educacion educ) {
        educacionRepo.save(educ);
    }

    public void delete(int id) {
        educacionRepo.deleteById(id);
    }

    public boolean existsById(int id) {
        return educacionRepo.existsById(id);
    }
    
     public boolean existsByTituloEdu(String tituloEdu) {
        return educacionRepo.existsByTituloEdu(tituloEdu);
    }

}
