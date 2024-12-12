package br.com.vendas_api.dto;

import br.com.vendas_api.model.Endereco;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocioDtoSaida {

    private Long id;

    private String nome;

    private String sobrenome;

    private LocalDate dataNascimento;

    private Endereco endereco;

    private String email;

    private LocalDate dataDeAdmissao;
}
