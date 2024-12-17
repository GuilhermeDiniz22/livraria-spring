package br.com.vendas_api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RegistroNaoEncontradoException extends RuntimeException{

    private String mensagem;


    public RegistroNaoEncontradoException(String mensagem) {
        super(mensagem);
        this.mensagem = mensagem;
    }
}
