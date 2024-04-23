package br.com.neki.skills.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.skills.dto.AssociarSkillRequestDTO;
import br.com.neki.skills.dto.PessoaSkillItemResponseDTO;
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
	
	@Transactional
	public List<PessoaSkillItemResponseDTO> listaPessoaSkills(Integer idPessoa) {
		List<PessoaSkill> skillsEncontradas = pessoaRepository.findByIdPessoa(idPessoa).getPessoaSkills();
		List<PessoaSkillItemResponseDTO> listaPessoaSkillsResponse = new ArrayList<>();
		for(PessoaSkill pessoaSkill : skillsEncontradas) {
			PessoaSkillItemResponseDTO pessoaSkillItem = new PessoaSkillItemResponseDTO();
			pessoaSkillItem.setNomeSkill(pessoaSkill.getSkill().getNomeSkill());
			pessoaSkillItem.setNivelSkill(pessoaSkill.getNivel());
			listaPessoaSkillsResponse.add(pessoaSkillItem);
		}
		return listaPessoaSkillsResponse;
	}
	
	public PessoaSkill pessoaSkillById(Long id) {
		return pessoaSkillRepository.findByIdPessoaSkill(id).get();
	}
	
	@Transactional
	public PessoaSkill atualizarNivel(Long id, String nivel) {
		PessoaSkill pessoaSkillModel = pessoaSkillById(id);
		PessoaSkill pessoaSkill = new PessoaSkill();
		if(pessoaSkillModel.getNivel() != nivel) {
			pessoaSkillModel.setNivel(nivel);
		}
		else {
			pessoaSkill = pessoaSkillRepository.save(pessoaSkillModel);
		}
		return pessoaSkillModel;
	}
	
	@Transactional
	public void deletarPessoaSkill(Integer id) {
		pessoaSkillRepository.deleteById(id);
	}
	
}
