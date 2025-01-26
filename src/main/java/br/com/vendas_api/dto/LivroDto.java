package br.com.vendas_api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

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

    // Construtor sem argumentos
    public LivroDto() {
    }

    // Construtor com argumentos
    public LivroDto(Long id, String nome, String autor, String editora, String descricao, Integer copiasDisponiveis, BigDecimal preco, String imagem, String categoria) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.descricao = descricao;
        this.copiasDisponiveis = copiasDisponiveis;
        this.preco = preco;
        this.imagem = imagem;
        this.categoria = categoria;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCopiasDisponiveis() {
        return copiasDisponiveis;
    }

    public void setCopiasDisponiveis(Integer copiasDisponiveis) {
        this.copiasDisponiveis = copiasDisponiveis;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
