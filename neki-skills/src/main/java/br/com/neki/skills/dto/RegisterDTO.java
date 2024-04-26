package br.com.neki.skills.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.neki.skills.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RegisterDTO {
	@JsonProperty("login")
	String login;
	@JsonProperty("senha")
	String senha;
	UserRole role;
	String nomePessoa;
}
