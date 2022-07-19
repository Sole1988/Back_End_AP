
package com.example.AP.Sevices;

import com.example.AP.Entity.Skills;
import com.example.AP.Interface.ISkills;
import com.example.AP.Repository.SkillsRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillsService implements ISkills{

    @Autowired SkillsRepo skillsRepo;

   @Override
    public List<Skills> getSkills() {
        List<Skills> skills = skillsRepo.findAll();
        return skills;
    }

    @Override
    public void saveSkills(Skills skills) {
        skillsRepo.save(skills);
    }

    @Override
    public void deleteSkills(Long id) {
        skillsRepo.deleteById(id);
    }

    @Override
    public Skills findSkills(Long id) {
        Skills skills = skillsRepo.findById(id).orElseThrow(null);
        return skills;
    }

    
}
