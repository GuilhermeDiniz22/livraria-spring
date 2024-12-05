package br.com.vendas_api.repository;

import br.com.vendas_api.model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroRepository extends JpaRepository<Registro, Long> {
}
