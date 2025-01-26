package br.com.vendas_api.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "livros")
@SQLRestriction("ativo = true")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private String editora;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false, name = "copias_disponiveis")
    private Integer copiasDisponiveis;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private String imagem;

    @Column(nullable = false)
    private String categoria;

    @Column(name = "criado_em")
    @CreationTimestamp
    private LocalDateTime criadoEm;

    @Column(nullable = false)
    private boolean ativo;

    public Livro(Long id, String nome, String autor, String editora, String descricao, Integer copiasDisponiveis, BigDecimal preco, String imagem, String categoria, LocalDateTime criadoEm, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.descricao = descricao;
        this.copiasDisponiveis = copiasDisponiveis;
        this.preco = preco;
        this.imagem = imagem;
        this.categoria = categoria;
        this.criadoEm = criadoEm;
        this.ativo = ativo;
    }

    public Livro() {
    }

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

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return ativo == livro.ativo && Objects.equals(id, livro.id) && Objects.equals(nome, livro.nome) && Objects.equals(autor, livro.autor) && Objects.equals(editora, livro.editora) && Objects.equals(descricao, livro.descricao) && Objects.equals(copiasDisponiveis, livro.copiasDisponiveis) && Objects.equals(preco, livro.preco) && Objects.equals(imagem, livro.imagem) && Objects.equals(categoria, livro.categoria) && Objects.equals(criadoEm, livro.criadoEm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, autor, editora, descricao, copiasDisponiveis, preco, imagem, categoria, criadoEm, ativo);
    }
}
