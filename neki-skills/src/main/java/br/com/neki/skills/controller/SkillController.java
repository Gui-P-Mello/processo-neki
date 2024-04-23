package br.com.neki.skills.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.skills.model.Skill;
import br.com.neki.skills.service.SkillService;

@RestController
@RequestMapping("/skills")
public class SkillController {
	@Autowired
	SkillService skillService;
	
	@GetMapping("/listar-opcoes")
	public ResponseEntity<List<Skill>> listarOpcoes(){
		List<Skill> opcoes = skillService.listarOpcoes();
		return ResponseEntity.status(HttpStatus.OK).body(opcoes);
	}
}
