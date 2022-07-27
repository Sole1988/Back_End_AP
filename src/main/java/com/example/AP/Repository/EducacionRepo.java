
package com.example.AP.Repository;

import com.example.AP.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EducacionRepo extends JpaRepository <Educacion, Integer>{
    
    public Optional<Educacion> findByTituloEdu(String tituloEdu);
    public boolean existsByTituloEdu(String tituloEdu);
}
