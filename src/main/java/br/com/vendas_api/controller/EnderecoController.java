package br.com.vendas_api.controller;

import br.com.vendas_api.dto.EnderecoDto;
import br.com.vendas_api.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/endereco")
@CrossOrigin(origins = "http://perceptive-laughter-production.up.railway.app")
@Tag(
        name = "API Endereço",
        description = "API responsável pelos serviços da entidade endereço no sistema."
)
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    @Operation(
            summary = "Adicionar um novo endereço",
            description = "Recebe um DTO de endereço, valida os dados e salva no banco de dados."
    )
    public ResponseEntity<String> adicionarEndereco(@Valid @RequestBody EnderecoDto enderecoDto) {
        String response = enderecoService.postEndereco(enderecoDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    @Operation(
            summary = "Atualizar um endereço existente",
            description = "Atualiza os dados de um endereço identificado pelo ID fornecido."
    )
    public ResponseEntity<String> atualizarEndereco(@PathVariable Long id, @Valid @RequestBody EnderecoDto enderecoDto) {
        String response = enderecoService.putEndereco(id, enderecoDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(
            summary = "Listar todos os endereços",
            description = "Retorna uma lista de todos os endereços cadastrados no sistema."
    )
    public ResponseEntity<List<EnderecoDto>> pegarEnderecos() {
        List<EnderecoDto> response = enderecoService.getEnderecos();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Obter detalhes de um endereço",
            description = "Retorna os detalhes de um endereço específico identificado pelo ID."
    )
    public ResponseEntity<EnderecoDto> pegarEnderecoPorID(@PathVariable Long id) {
        EnderecoDto response = enderecoService.getEnderecoById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @Operation(
            summary = "Excluir um endereço",
            description = "Exclui um endereço específico identificado pelo ID fornecido."
    )
    public ResponseEntity<String> deletarEndereco(@PathVariable Long id) {
        String response = enderecoService.deleteEndereco(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
