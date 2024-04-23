package br.com.neki.skills.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
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
public class Pessoa implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "pessoas_seq", sequenceName = "pessoas_seq", allocationSize = 1)
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
	@OneToMany(mappedBy = "pessoa")
	private List<PessoaSkill> pessoaSkills = new ArrayList<>();
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
