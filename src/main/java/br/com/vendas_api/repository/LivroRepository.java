package br.com.vendas_api.repository;

import br.com.vendas_api.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(exported = false)
public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByNomeIgnoreCaseContaining( String nome);

    List<Livro> findByNomeContainingIgnoreCaseAndAutorContainingIgnoreCase(String nome, String autor);

}
