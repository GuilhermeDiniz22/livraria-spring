package br.com.vendas_api.dto;

import br.com.vendas_api.model.Endereco;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SocioDtoSaida {

    private Long id;

    private String nome;

    private String sobrenome;

    private LocalDate dataNascimento;

    private EnderecoDto endereco;

    private LivroDto livro;

    private String email;

    private LocalDate dataDeAdmissao;

    public SocioDtoSaida(Long id, String nome, String sobrenome, LocalDate dataNascimento, EnderecoDto endereco, LivroDto livro, String email, LocalDate dataDeAdmissao) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.livro = livro;
        this.email = email;
        this.dataDeAdmissao = dataDeAdmissao;
    }

    public SocioDtoSaida() {
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

    public EnderecoDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDto endereco) {
        this.endereco = endereco;
    }

    public LivroDto getLivro() {
        return livro;
    }

    public void setLivro(LivroDto livro) {
        this.livro = livro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(LocalDate dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }
}
