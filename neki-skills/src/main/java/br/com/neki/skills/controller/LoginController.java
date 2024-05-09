package br.com.neki.skills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.skills.dto.RegisterDTO;
import br.com.neki.skills.model.Pessoa;
import br.com.neki.skills.repository.PessoaRepository;
import br.com.neki.skills.service.TokenService;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("login")
public class LoginController {
	
//	@Autowired
//	AuthenticationManager authenticationManager;
	@Autowired
	PessoaRepository pessoaRepository;
	@Autowired
	TokenService tokenService;
	
//	@PostMapping("login")
//	public ResponseEntity login(@RequestBody AuthDTO dados) {
//		var usernamePassword = new UsernamePasswordAuthenticationToken(dados.getLogin(), dados.getSenha());
//		var auth = authenticationManager.authenticate(usernamePassword);
//		
//		var token = tokenService.generateToken((Pessoa) auth.getPrincipal());
//		
//		return ResponseEntity.ok(new LoginResponseDTO(token));
//	}
	
	@Operation(
            summary = "Cadastra um novo usuário",
//            security = @SecurityRequirement(name = "autenticacaoBearer"),
            description = "Cadastra um novo usuário e suas informações pessoais a com os dados fornecidos pelo json recebido na request."
        )
	@PostMapping("register")
	public ResponseEntity<Pessoa>  register(@RequestBody RegisterDTO dados) {
		if(this.pessoaRepository.findByLogin(dados.getLogin()) != null) {
			return ResponseEntity.badRequest().build();
		}
		else {
//			String senhaEncriptada = new BCryptPasswordEncoder().encode(dados.getSenha());
			Pessoa pessoaCadastro = new Pessoa();
			pessoaCadastro.setLogin(dados.getLogin());
			pessoaCadastro.setSenha(dados.getSenha());
			pessoaCadastro.setUserRole(dados.getRole());
			pessoaCadastro.setNomePessoa(dados.getNomePessoa());
			
			pessoaRepository.save(pessoaCadastro);
			return ResponseEntity.status(HttpStatus.CREATED).body(pessoaCadastro);
		}
	}

}
