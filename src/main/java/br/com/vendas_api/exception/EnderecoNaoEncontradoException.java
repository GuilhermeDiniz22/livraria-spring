package br.com.vendas_api.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@NoArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EnderecoNaoEncontradoException extends RuntimeException{

    private String mensagem;


    public EnderecoNaoEncontradoException(String mensagem) {
        this.mensagem = mensagem;
    }
}
