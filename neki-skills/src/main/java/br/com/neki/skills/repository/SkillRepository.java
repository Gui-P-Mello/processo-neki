package br.com.neki.skills.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.neki.skills.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository <Skill, Integer>{
	@Query(value = "SELECT * FROM skills where nome_skill = :nomeSkill", nativeQuery = true)
	Skill findByNomeSkill(@Param("nomeSkill") String nomeSkill);

}



