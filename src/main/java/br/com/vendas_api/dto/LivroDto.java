package br.com.vendas_api.dto;

import br.com.vendas_api.model.Livro;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class LivroDto {

    private Long id;

    private String nome;

    private String autor;

    private String editora;

    private String descricao;

    private Integer copiasDisponiveis;

    private BigDecimal preco;

    private String imagem;

    private String categoria;


}
