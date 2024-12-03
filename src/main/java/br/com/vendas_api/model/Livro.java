package br.com.vendas_api.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.IdGeneratorType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "livros")
@Data
public class Livro {
    @Id
    private Long id;

    private String nome;

    private String autor;

    private String editora;

    private String descricao;

    private BigDecimal preco;

    private String imagem;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    private boolean ativo;
}
