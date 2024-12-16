package br.com.vendas_api.dto;

import br.com.vendas_api.model.Livro;
import br.com.vendas_api.model.Socio;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RegistroDtoSaida {

    private Long id;

    private String nomeLivro;

    private SocioDtoSaida socio;

    private LocalDate dataAluguel;

    private LocalDate dataEntrega;

    private Integer multa;

}
