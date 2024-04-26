package br.com.neki.skills.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.neki.skills.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	@Query(value = "Select * from pessoas where id_pessoa= :id", nativeQuery = true)
	Pessoa findByIdPessoa(@Param("id") Integer id);
	
	Optional<Pessoa> findByIdPessoa(Long id);
//	Optional<Pessoa> findByLogin(String login);
	UserDetails findByLogin(String login);
}
