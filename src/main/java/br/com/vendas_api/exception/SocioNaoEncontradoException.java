package br.com.vendas_api.exception;

public class SocioNaoEncontradoException extends RuntimeException{

    private String mensagem;

    private Long id;

    public SocioNaoEncontradoException(String mensagem, Long id) {
        this.mensagem = mensagem;
        this.id = id;
    }

    public SocioNaoEncontradoException(String mensagem) {
        this.mensagem = mensagem;
    }
}
