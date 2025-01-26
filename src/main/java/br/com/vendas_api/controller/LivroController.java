package br.com.vendas_api.controller;

import br.com.vendas_api.dto.LivroDto;
import br.com.vendas_api.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://perceptive-laughter-production.up.railway.app")
@RequestMapping("api/livros")
@Tag(
        name = "API Livros",
        description = "API responsável pelos serviços da entidade Livro no sistema."
)
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    @Operation(
            summary = "Listar todos os livros",
            description = "Retorna uma lista com todos os livros cadastrados no sistema."
    )
    public ResponseEntity<List<LivroDto>> getAllLivros() {
        List<LivroDto> livros = livroService.getAllLivros();
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Obter detalhes de um livro",
            description = "Retorna os detalhes de um livro específico identificado pelo ID."
    )
    public ResponseEntity<LivroDto> getLivroById(@PathVariable Long id) {
        LivroDto livro = livroService.getLivroById(id);
        return new ResponseEntity<>(livro, HttpStatus.OK);
    }

    @GetMapping("procurar-nome")
    @Operation(
            summary = "Buscar livros por nome",
            description = "Retorna uma lista de livros cujo nome contém o valor especificado."
    )
    public ResponseEntity<List<LivroDto>> getLivroByNomeFiltro(@RequestParam String nome) {
        List<LivroDto> retorno = livroService.getLivrosByNomeContaining(nome);
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }

    @GetMapping("procurar-nome&autor")
    @Operation(
            summary = "Buscar livros por nome e autor",
            description = "Retorna uma lista de livros cujo nome e autor contêm os valores especificados."
    )
    public ResponseEntity<List<LivroDto>> getLivroByNomeAutor(@RequestParam String nome, @RequestParam String autor) {
        List<LivroDto> retorno = livroService.getLivrosByNomeEAutorContaining(nome, autor);
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }

    @GetMapping("{socioId}/alugar/{livroId}")
    @Operation(
            summary = "Alugar um livro",
            description = "Permite que um sócio alugue um livro específico identificado pelo ID."
    )
    public ResponseEntity<String> alugarLivro(@PathVariable Long socioId, @PathVariable Long livroId) {
        String response = livroService.alugarLivro(socioId, livroId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{socioId}/devolver/{livroId}")
    @Operation(
            summary = "Devolver um livro",
            description = "Permite que um sócio devolva um livro alugado, identificado pelo ID."
    )
    public ResponseEntity<String> devolverLivro(@PathVariable Long socioId, @PathVariable Long livroId) {
        String response = livroService.devolverLivro(socioId, livroId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    @Operation(
            summary = "Adicionar um novo livro",
            description = "Recebe um DTO de livro, valida os dados e salva no banco de dados."
    )
    public ResponseEntity<String> postLivro(@Valid @RequestBody LivroDto livro) {
        String response = livroService.saveLivro(livro);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    @Operation(
            summary = "Atualizar um livro existente",
            description = "Atualiza os dados de um livro identificado pelo ID fornecido."
    )
    public ResponseEntity<String> putLivro(@PathVariable Long id, @Valid @RequestBody LivroDto livro) {
        String response = livroService.updateLivro(id, livro);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    @Operation(
            summary = "Excluir um livro",
            description = "Exclui um livro específico identificado pelo ID fornecido."
    )
    public ResponseEntity<String> deleteLivro(@PathVariable Long id) {
        String response = livroService.deleteLivro(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
