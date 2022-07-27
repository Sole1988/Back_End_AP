
package com.example.AP.Repository;

import com.example.AP.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepo  extends JpaRepository<Experiencia, Integer> {
  
    public Optional<Experiencia> findByEmpresaExp(String empresaExp);
    public boolean existsByEmpresaExp(String empresaExp);
    
       
}
