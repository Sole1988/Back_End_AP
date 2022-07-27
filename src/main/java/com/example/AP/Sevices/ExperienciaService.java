
package com.example.AP.Sevices;

import com.example.AP.Entity.Experiencia;
import com.example.AP.Repository.ExperienciaRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {

    @Autowired
    ExperienciaRepo experienciaRepo;

    public List<Experiencia> list() {
        return experienciaRepo.findAll();
    }

    public Optional<Experiencia> getOne(int id) {
        return experienciaRepo.findById(id);
    }

    public Optional<Experiencia> getByEmpresaExp(String empresaExp) {
        return experienciaRepo.findByEmpresaExp(empresaExp);
    }

    public void save(Experiencia expe) {
        experienciaRepo.save(expe);
    }

    public void delete(int id) {
        experienciaRepo.deleteById(id);
    }

    public boolean existsById(int id) {
        return experienciaRepo.existsById(id);
    }

    public boolean existsByEmpresaExp(String empresaExp) {
        return experienciaRepo.existsByEmpresaExp(empresaExp);
    }

}
