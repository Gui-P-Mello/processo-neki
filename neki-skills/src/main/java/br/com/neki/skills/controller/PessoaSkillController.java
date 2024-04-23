package br.com.neki.skills.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.skills.dto.AssociarSkillRequestDTO;
import br.com.neki.skills.dto.PessoaSkillItemResponseDTO;
import br.com.neki.skills.model.PessoaSkill;
import br.com.neki.skills.service.PessoaSkillService;

@RestController
@RequestMapping("/pessoa-skill")
public class PessoaSkillController {
	@Autowired
	PessoaSkillService pessoaSkillService;
	
	@PostMapping("associar-skill")
	public ResponseEntity<PessoaSkill> postPessoaSkill(@RequestBody AssociarSkillRequestDTO pessoaSkillDTO){
		PessoaSkill pessoaSkillCriada = pessoaSkillService.createPessoaSkill(pessoaSkillDTO); 
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSkillCriada);
	}
	
	@GetMapping("listar-pessoa-skills/{id}")
	public ResponseEntity<List<PessoaSkillItemResponseDTO>> getPessoaSkills(@PathVariable Integer id){
		List<PessoaSkillItemResponseDTO> listaPessoaSkils = pessoaSkillService.listaPessoaSkills(id);
		return ResponseEntity.status(HttpStatus.OK).body(listaPessoaSkils);
	}

}
