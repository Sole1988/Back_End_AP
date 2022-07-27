
package com.example.AP.Repository;

import com.example.AP.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepo extends JpaRepository  <Proyecto, Integer>  {
    
    public Optional<Proyecto> findByTituloProyecto(String tituloProyecto);
    public boolean existsByTituloProyecto(String tituloProyecto);
}
