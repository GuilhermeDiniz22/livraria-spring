package br.com.vendas_api.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class EnderecoNaoEncontradoException extends RuntimeException{

    private String mensagem;

    private Long id;


    public EnderecoNaoEncontradoException(String mensagem) {
        this.mensagem = mensagem;
    }
}
