package br.com.neki.skills.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.neki.skills.model.PessoaSkill;

@Repository
public interface PessoaSkillRepository extends JpaRepository<PessoaSkill, Integer>{

}
