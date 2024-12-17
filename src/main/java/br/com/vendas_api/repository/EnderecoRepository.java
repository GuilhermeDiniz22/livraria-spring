package br.com.vendas_api.repository;

import br.com.vendas_api.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Endereco findEnderecoBySocioId(Long id);
}
