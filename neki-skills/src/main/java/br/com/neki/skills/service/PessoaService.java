package br.com.neki.skills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.neki.skills.config.JWTUtil;
import br.com.neki.skills.model.Pessoa;
import br.com.neki.skills.repository.PessoaRepository;

@Service
public class PessoaService {
	
	private static final String BEARER = "Bearer ";
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
    private JWTUtil jwtUtil;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	public Pessoa createPessoa(Pessoa pessoa) {
		pessoa.setSenha(passwordEncoder.encode(pessoa.getSenha()));
		return pessoaRepository.save(pessoa);
	}

}
