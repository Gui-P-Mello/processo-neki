package br.com.neki.skills.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.skills.model.Skill;
import br.com.neki.skills.repository.SkillRepository;

@Service
public class SkillService {
	
	@Autowired
	SkillRepository skillRepository;
	
	public List<Skill> listarOpcoes() {
		List<Skill> opcoes = skillRepository.findAll();
		return opcoes;
	}
}
