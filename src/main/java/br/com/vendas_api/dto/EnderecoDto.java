package br.com.vendas_api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


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

    public EnderecoDto(Long id, String rua, String numero, String cep, String bairro, String complemento) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.complemento = complemento;
    }

    public EnderecoDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
