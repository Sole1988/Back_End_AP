
package com.example.AP.Sevices;

import com.example.AP.Entity.Persona;
import com.example.AP.Interface.IPersona;
import com.example.AP.Repository.PersonaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersona {

    @Autowired PersonaRepo  personaRepo;
    

    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = personaRepo.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepo.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = personaRepo.findById(id).orElseThrow(null);
        return persona;
    }

}
    
    

        