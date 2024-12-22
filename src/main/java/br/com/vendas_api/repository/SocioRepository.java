package br.com.vendas_api.repository;

import br.com.vendas_api.model.Livro;
import br.com.vendas_api.model.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(exported = false)
public interface SocioRepository extends JpaRepository<Socio, Long> {

    List<Socio> findByNomeContainingIgnoreCaseAndSobrenomeContainingIgnoreCase(String nome, String sobrenome);

    List<Socio> findByNomeContainingIgnoreCase(String nome);
}
