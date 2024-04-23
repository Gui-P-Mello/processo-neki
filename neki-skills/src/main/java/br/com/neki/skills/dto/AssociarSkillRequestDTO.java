package br.com.neki.skills.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AssociarSkillRequestDTO {
	private Integer pessoaId;
	private String skillNome;
	private String skillNivel;
	
}
