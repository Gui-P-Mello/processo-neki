package br.com.neki.skills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.skills.dto.AssociarSkillRequestDTO;
import br.com.neki.skills.model.Pessoa;
import br.com.neki.skills.model.PessoaSkill;
import br.com.neki.skills.model.Skill;
import br.com.neki.skills.repository.PessoaRepository;
import br.com.neki.skills.repository.PessoaSkillRepository;
import br.com.neki.skills.repository.SkillRepository;
import jakarta.transaction.Transactional;

@Service
public class PessoaSkillService {
	
	@Autowired
	PessoaSkillRepository pessoaSkillRepository;
	
	@Autowired
	SkillRepository skillRepository;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Transactional
	public PessoaSkill createPessoaSkill(AssociarSkillRequestDTO pessoaSkillDTO) {
		
		PessoaSkill pessoaSkill = new PessoaSkill();
		Skill skill = skillRepository.findByNomeSkill(pessoaSkillDTO.getSkillNome());		
		Pessoa pessoa = pessoaRepository.findByIdPessoa(pessoaSkillDTO.getPessoaId());
		
		pessoaSkill.setPessoa(pessoa);
		pessoaSkill.setSkill(skill);
		pessoaSkill.setNivel(pessoaSkillDTO.getSkillNivel());
		return pessoaSkillRepository.save(pessoaSkill);
	}
	
}
