package br.com.neki.skills.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.skills.dto.AssociarSkillRequestDTO;
import br.com.neki.skills.dto.PessoaSkillItemResponseDTO;
import br.com.neki.skills.model.PessoaSkill;
import br.com.neki.skills.service.PessoaSkillService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/pessoa-skill")
public class PessoaSkillController {
	@Autowired
	PessoaSkillService pessoaSkillService;
	
	@Operation(
            summary = "Associa uma skill a um usuário",
            description = "Associa uma skill a um usuário informado por id."
        )
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
	
	@PutMapping("atualizar-nivel/{id}")
	public ResponseEntity<PessoaSkill> atualizarNivel(@PathVariable Long id, @RequestParam String nivel){
		PessoaSkill pessoaSkillAtualizada = pessoaSkillService.atualizarNivel(id, nivel);
		return ResponseEntity.status(HttpStatus.OK).body(pessoaSkillAtualizada);
	}
	
	@DeleteMapping("deletar-pessoa-skill/{id}")
	public ResponseEntity<String> deletarPessoaSkill(@PathVariable Integer id){
		pessoaSkillService.deletarPessoaSkill(id);
		String mensagem = "Associação com skill deletada com sucesso";
		return ResponseEntity.status(HttpStatus.OK).body(mensagem);
	}

}
