package br.com.vendas_api.repository;

import br.com.vendas_api.model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;


@RepositoryRestResource(exported = false)
@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {

    List<Registro> findAllBySocioId(Long id);

    Registro findBySocioId(Long id);
}
