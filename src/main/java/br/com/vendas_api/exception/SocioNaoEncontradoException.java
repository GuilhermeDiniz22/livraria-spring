package br.com.vendas_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SocioNaoEncontradoException extends RuntimeException{


    private String mensagem;


    public SocioNaoEncontradoException(String mensagem) {
        super(mensagem);
        this.mensagem = mensagem;
    }
}
