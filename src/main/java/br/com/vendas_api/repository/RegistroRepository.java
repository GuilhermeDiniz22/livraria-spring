package br.com.vendas_api.repository;

import br.com.vendas_api.model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {

    List<Registro> findAllBySocioId(Long id);

    Registro findBySocioId(Long id);
}
