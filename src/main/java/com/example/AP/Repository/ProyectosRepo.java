
package com.example.AP.Repository;

import com.example.AP.Entity.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosRepo  extends JpaRepository<Proyectos, Long>{
     
    
    
}
