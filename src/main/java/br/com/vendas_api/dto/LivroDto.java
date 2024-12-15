package br.com.vendas_api.dto;

import br.com.vendas_api.model.Livro;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LivroDto {

    private Long id;

    @NotNull(message = "O nome deve ser preenchido")
    @NotBlank(message = "O nome deve ser preenchido")
    private String nome;

    @NotNull(message = "O autor deve ser preenchido")
    @NotBlank(message = "O autor deve ser preenchido")
    private String autor;

    @NotNull(message = "A editora deve ser preenchida")
    @NotBlank(message = "A editora deve ser preenchida")
    private String editora;

    @NotNull(message = "A descrição deve ser preenchida")
    @NotBlank(message = "A descrição deve ser preenchida")
    private String descricao;

    @NotNull(message = "As cópias disponíveis devem ser preenchidas")
    @NotBlank(message = "As cópias disponíveis devem ser preenchidas")
    private Integer copiasDisponiveis;

    @NotNull(message = "O preço deve ser preenchido")
    @NotBlank(message = "O preço deve ser preenchido")
    private BigDecimal preco;

    @NotNull(message = "A imagem deve ser preenchida")
    @NotBlank(message = "A imagem deve ser preenchida")
    private String imagem;

    @NotNull(message = "A categoria deve ser preenchida")
    @NotBlank(message = "A categoria deve ser preenchida")
    private String categoria;

}
