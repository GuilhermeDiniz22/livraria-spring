package br.com.vendas_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class SocioDtoEntrada {

    private Long id;

    @NotNull(message = "O nome deve ser preenchido")
    @NotBlank(message = "O nome não pode estar em branco")
    private String nome;

    @NotNull(message = "O sobrenome deve ser preenchido")
    @NotBlank(message = "O sobrenome não pode estar em branco")
    private String sobrenome;

    @NotNull(message = "A data de nascimento deve ser preenchida")
    private LocalDate dataNascimento;

    @NotNull(message = "O endereço deve ser preenchido")
    private Long enderecoId;

    @Email
    @NotNull(message = "O email deve ser preenchido")
    @NotBlank(message = "O email não pode estar em branco")
    private String email;

    // Construtor sem argumentos
    public SocioDtoEntrada() {
    }

    // Construtor com argumentos
    public SocioDtoEntrada(Long id, String nome, String sobrenome, LocalDate dataNascimento, Long enderecoId, String email) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.enderecoId = enderecoId;
        this.email = email;
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

    public Long getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Long enderecoId) {
        this.enderecoId = enderecoId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
