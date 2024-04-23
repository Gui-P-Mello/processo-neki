package br.com.neki.skills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.skills.model.Pessoa;
import br.com.neki.skills.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	public Pessoa createPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

}
