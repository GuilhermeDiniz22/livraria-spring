package br.com.vendas_api.controller;

import br.com.vendas_api.dto.LivroDto;
import br.com.vendas_api.model.Livro;
import br.com.vendas_api.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroDto>> getAllLivros(){
        List<LivroDto> livros = livroService.getAllLivros();

        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<LivroDto> getLivroById(@PathVariable Long id){
        LivroDto livro = livroService.getLivroById(id);

        return new ResponseEntity<>(livro, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> postLivro(@RequestBody Livro livro){
        String response = livroService.saveLivro(livro);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
