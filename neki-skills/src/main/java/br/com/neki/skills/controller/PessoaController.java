package br.com.neki.skills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.skills.model.Pessoa;
import br.com.neki.skills.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Pessoa> postPessoa(@RequestBody Pessoa pessoa){
		Pessoa pessoaCriada = pessoaService.createPessoa(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaCriada);
	}

}
