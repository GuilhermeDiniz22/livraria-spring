package br.com.vendas_api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EnderecoDto {

    private Long id;

    @NotNull(message = "A rua deve ser preenchida")
    @NotBlank(message = "A rua deve ser preenchida")
    private String rua;

    @NotNull(message = "O número deve ser preenchido")
    @NotBlank(message = "O número deve ser preenchido")
    private String numero;

    @NotNull(message = "O cep deve ser preenchido")
    @NotBlank(message = "O cep deve ser preenchido")
    private String cep;

    @NotNull(message = "O bairro deve ser preenchido")
    @NotBlank(message = "O bairro deve ser preenchido")
    private String bairro;

    @NotNull(message = "O complemento deve ser preenchido")
    @NotBlank(message = "O complemento deve ser preenchido")
    private String complemento;
}
