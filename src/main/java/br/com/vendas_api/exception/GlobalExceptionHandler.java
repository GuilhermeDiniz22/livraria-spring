package br.com.vendas_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroGenerico> handleException(
            Exception ex,
            WebRequest webRequest){
        
    ErroGenerico response = new ErroGenerico(
            ex.getLocalizedMessage(),
            webRequest.getContextPath(),
            "ERRO DE SERVIDOR",
            LocalDate.now());

    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(LivroNaoEncontradoException.class)
    public ResponseEntity<ErroGenerico> handleLivroNaoEncontradoException(
            Exception ex,
            WebRequest webRequest){

        ErroGenerico response = new ErroGenerico(
                ex.getMessage(),
                webRequest.getDescription(false),
                "LIVRO NÃO ENCONTRADO",
                LocalDate.now());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
