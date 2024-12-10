package br.com.vendas_api.exception;


public class LivroNaoEncontradoException extends RuntimeException{

    private String mensagem;

    private String nome;

    public LivroNaoEncontradoException(String mensagem, String nome) {
        this.mensagem = mensagem;
        this.nome = nome;
    }

    public LivroNaoEncontradoException(String mensagem) {
        this.mensagem = mensagem;
    }
}
