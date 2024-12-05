package br.com.vendas_api.controller;

import br.com.vendas_api.model.Livro;
import br.com.vendas_api.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<String> postLivro(@RequestBody Livro livro){
        String response = livroService.saveLivro(livro);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
