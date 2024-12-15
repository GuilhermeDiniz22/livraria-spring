package br.com.vendas_api.dto;

import br.com.vendas_api.model.Endereco;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SocioDtoSaida {

    private Long id;

    private String nome;

    private String sobrenome;

    private LocalDate dataNascimento;

    private EnderecoDto endereco;

    private LivroDto livro;

    private String email;

    private LocalDate dataDeAdmissao;
}
