
package com.example.AP.Repository;

import com.example.AP.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepo extends JpaRepository<Persona, Long> {

    public boolean existsById(int id);

}
