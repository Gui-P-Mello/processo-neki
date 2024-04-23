package br.com.neki.skills.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.neki.skills.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	@Query(value = "Select * from pessoas where id_pessoa= :id", nativeQuery = true)
	Pessoa findByIdPessoa(@Param("id") Integer id);
}
