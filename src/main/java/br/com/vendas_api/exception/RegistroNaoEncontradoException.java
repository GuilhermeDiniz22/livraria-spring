package br.com.vendas_api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class RegistroNaoEncontradoException extends RuntimeException{

    private String mensagem;

    private Long id;

    public RegistroNaoEncontradoException(String mensagem) {
        this.mensagem = mensagem;
    }

    public RegistroNaoEncontradoException(String mensagem, Long id) {
        this.mensagem = mensagem;
        this.id = id;
    }
}
