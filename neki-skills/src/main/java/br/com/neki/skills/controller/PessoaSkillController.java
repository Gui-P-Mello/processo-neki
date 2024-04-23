package br.com.neki.skills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.skills.dto.AssociarSkillRequestDTO;
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

}
