package br.com.vendas_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ResponseDto {

    private String nome;

    private String token;

    public ResponseDto(String nome, String token) {
        this.nome = nome;
        this.token = token;
    }

    public ResponseDto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
