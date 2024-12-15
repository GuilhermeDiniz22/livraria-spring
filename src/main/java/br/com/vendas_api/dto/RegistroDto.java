package br.com.vendas_api.dto;

import br.com.vendas_api.model.Livro;
import br.com.vendas_api.model.Socio;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RegistroDto {

    private Long id;

    private Socio socio;

    private Livro livro;

    private LocalDate dataAluguel;

    private LocalDate dataEntrega;

    private Integer multa;

}
