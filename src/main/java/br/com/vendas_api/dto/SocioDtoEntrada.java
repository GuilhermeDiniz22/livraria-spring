package br.com.vendas_api.dto;

import br.com.vendas_api.model.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocioDtoEntrada {

    private Long id;

    @NotNull(message = "O nome deve ser preenchido")
    @NotBlank(message = "O nome deve ser preenchido")
    private String nome;

    @NotNull(message = "O sobrenome deve ser preenchido")
    @NotBlank(message = "O sobrenome deve ser preenchido")
    private String sobrenome;

    @NotNull(message = "A data de nascimento deve ser preenchida")
    @NotBlank(message = "A data de nascimento deve ser preenchida")
    private LocalDate dataNascimento;

    @NotNull(message = "O endereço deve ser preenchido")
    @NotBlank(message = "O endereço deve ser preenchido")
    private Long enderecoId;

    @Email
    @NotNull(message = "O email deve ser preenchido")
    @NotBlank(message = "O email deve ser preenchido")
    private String email;

}
