package br.com.vendas_api.repository;

import br.com.vendas_api.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(exported = false)
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {


}
