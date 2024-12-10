package br.com.vendas_api.repository;

import br.com.vendas_api.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {


    @Query("SELECT l FROM Livro l WHERE LOWER(l.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Livro> findByNomeIgnoreCaseContaining(@Param("nome") String nome);

    List<Livro> findByNomeAndAutorIgnoreCaseContaining(String nome, String autor);
}
