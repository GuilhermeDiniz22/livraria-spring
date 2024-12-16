package br.com.vendas_api.repository;

import br.com.vendas_api.model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroRepository extends JpaRepository<Registro, Long> {

    List<Registro> findAllBySocioId(Long id);

    Registro findBySocioId(Long id);
}
