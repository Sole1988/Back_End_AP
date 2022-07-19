
package com.example.AP.Sevices;


import com.example.AP.Entity.Educacion;
import com.example.AP.Interface.IEducacion;
import com.example.AP.Repository.EducacionRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService implements IEducacion{
 
       @Autowired EducacionRepo educacionRepo;
    

    @Override
    public List<Educacion> getEducacion() {
        List<Educacion> educacion = educacionRepo.findAll();
        return educacion;
    }

    @Override
    public void saveEducacion(Educacion educacion) {
        educacionRepo.save(educacion);
    }

    @Override
    public void deleteEducacion(Long id) {
        educacionRepo.deleteById(id);
    }

    @Override
    public Educacion findEducacion(Long id) {
        Educacion educacion = educacionRepo.findById(id).orElseThrow(null);
        return educacion;
    }
}