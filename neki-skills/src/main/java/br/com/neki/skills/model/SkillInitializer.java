package br.com.neki.skills.model;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.neki.skills.enums.SkillEnum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class SkillInitializer implements ApplicationRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(ApplicationArguments args) {
        List<Skill> skills = entityManager.createQuery("SELECT s FROM Skill s", Skill.class).getResultList();
        if (skills.isEmpty()) {
            for (SkillEnum skillEnum : SkillEnum.values()) {
                Skill skill = new Skill();
                skill.setNomeSkill(skillEnum.getNomeSkill());
                entityManager.persist(skill);
            }
        }
    }
}