package br.com.neki.skills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.skills.dto.AuthDTO;
import br.com.neki.skills.dto.LoginResponseDTO;
import br.com.neki.skills.dto.RegisterDTO;
import br.com.neki.skills.model.Pessoa;
import br.com.neki.skills.repository.PessoaRepository;
import br.com.neki.skills.service.TokenService;


@RestController
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PessoaRepository pessoaRepository;
	@Autowired
	TokenService tokenService;
	
	@PostMapping("login")
	public ResponseEntity login(@RequestBody AuthDTO dados) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(dados.getLogin(), dados.getSenha());
		var auth = authenticationManager.authenticate(usernamePassword);
		
		var token = tokenService.generateToken((Pessoa) auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping("register")
	public ResponseEntity<Pessoa>  register(@RequestBody RegisterDTO dados) {
		
		System.out.println("DADOS:"+ dados.toString());
		
		if(this.pessoaRepository.findByLogin(dados.getLogin()) != null) {
			return ResponseEntity.badRequest().build();
		}
		else {
			String senhaEncriptada = new BCryptPasswordEncoder().encode(dados.getSenha());
			Pessoa pessoaCadastro = new Pessoa();
			pessoaCadastro.setLogin(dados.getLogin());
			pessoaCadastro.setSenha(senhaEncriptada);
			pessoaCadastro.setUserRole(dados.getRole());
			pessoaCadastro.setNomePessoa(dados.getNomePessoa());
			
			pessoaRepository.save(pessoaCadastro);
			return ResponseEntity.status(HttpStatus.CREATED).body(pessoaCadastro);
		}
	}
	
	@GetMapping("teste")
	public ResponseEntity<RegisterDTO> teste(@RequestBody RegisterDTO register){
		System.out.println("REGISTER: "+register.toString());
		return ResponseEntity.status(HttpStatus.OK).body(register);
	}

}
