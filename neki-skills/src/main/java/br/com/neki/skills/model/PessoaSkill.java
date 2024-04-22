package br.com.neki.skills.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "pessoa_skill")
public class PessoaSkill {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_pessoa_skill")
	private Integer idPessoaSkill;
	@ManyToOne
	@JoinColumn(name = "id_pessoa_f_key")
	@JsonBackReference
	private Pessoa pessoa;
	@ManyToOne
	@JoinColumn(name = "id_skill_f_key")
	@NotNull
	private Skill skill;
	@NotNull
	@Column(name="senha")
	private String nivel;
}
