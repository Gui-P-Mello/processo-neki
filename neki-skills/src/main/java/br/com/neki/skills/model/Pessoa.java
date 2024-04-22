package br.com.neki.skills.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "pessoas")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_pessoa")
	private Integer idPessoa;
	@Column(name = "nome_pessoa")
	@NotNull
	private String nomePessoa;
	@Column(name = "login", unique = true)
	@NotNull
	private String login;
	@NotNull
	@Column(name = "senha")
	private String senha;
	@OneToMany
	private List<PessoaSkill> pessoaSkills;
	

}
