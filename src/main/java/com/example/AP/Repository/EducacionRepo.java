
package com.example.AP.Repository;


import com.example.AP.Entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepo  extends JpaRepository<Educacion, Long>{
    
      
    
}
