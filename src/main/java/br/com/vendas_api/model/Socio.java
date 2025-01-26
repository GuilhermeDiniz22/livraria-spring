package br.com.vendas_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "socios")
@SQLRestriction("ativo = true")
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "livro_id", nullable = true)
    private Livro livro;

    @Column
    @Email
    private String email;

    @Column(name = "data_admissao", nullable = false)
    private LocalDate dataDeAdmissao;

    @Column(name = "data_termino")
    private LocalDate dataDeTermino;

    @Column(nullable = false)
    private boolean ativo;

    public Socio(Long id, String nome, String sobrenome, LocalDate dataNascimento, Endereco endereco, Livro livro, String email, LocalDate dataDeAdmissao, LocalDate dataDeTermino, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.livro = livro;
        this.email = email;
        this.dataDeAdmissao = dataDeAdmissao;
        this.dataDeTermino = dataDeTermino;
        this.ativo = ativo;
    }

    public Socio() {
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public LocalDate getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(LocalDate dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }

    public LocalDate getDataDeTermino() {
        return dataDeTermino;
    }

    public void setDataDeTermino(LocalDate dataDeTermino) {
        this.dataDeTermino = dataDeTermino;
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
        Socio socio = (Socio) o;
        return ativo == socio.ativo && Objects.equals(id, socio.id) && Objects.equals(nome, socio.nome) && Objects.equals(sobrenome, socio.sobrenome) && Objects.equals(dataNascimento, socio.dataNascimento) && Objects.equals(endereco, socio.endereco) && Objects.equals(livro, socio.livro) && Objects.equals(email, socio.email) && Objects.equals(dataDeAdmissao, socio.dataDeAdmissao) && Objects.equals(dataDeTermino, socio.dataDeTermino);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sobrenome, dataNascimento, endereco, livro, email, dataDeAdmissao, dataDeTermino, ativo);
    }
}
