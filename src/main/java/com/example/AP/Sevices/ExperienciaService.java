
package com.example.AP.Sevices;

import com.example.AP.Entity.Experiencia;
import com.example.AP.Interface.IExperiencia;
import com.example.AP.Repository.ExperienciaRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService implements IExperiencia {
    
 @Autowired  ExperienciaRepo experienciaRepo;
    
   @Override
    public List<Experiencia> getExperiencia() {
        List<Experiencia> experiencia = experienciaRepo.findAll();
        return experiencia;
    }

    @Override
    public void saveExperiencia(Experiencia experiencia) {
        experienciaRepo.save(experiencia);
    }

    @Override
    public void deleteExperiencia(Long id) {
        experienciaRepo.deleteById(id);
    }

    @Override
    public Experiencia findExperiencia(Long id) {
        Experiencia experiencia = experienciaRepo.findById(id).orElseThrow(null);
        return experiencia;
    }

}
    

