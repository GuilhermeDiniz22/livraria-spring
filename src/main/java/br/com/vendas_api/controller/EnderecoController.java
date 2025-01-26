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
@Tag(
        name = "API Endereço",
        description = "API responsável pelos serviços da entidade endereço no sistema"
)
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    @Operation(
            summary = "Serviço responsável por salvar um endereço no sistema.",
            description = "O serviço recebe um enreço dto e converte em endereço antes de salvar no banco de dados."
    )
    public ResponseEntity<String> adicionarEndereco(@Valid @RequestBody EnderecoDto enderecoDto){
        String response = enderecoService.postEndereco(enderecoDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> atualizarEndereco(@PathVariable Long id, @Valid @RequestBody EnderecoDto enderecoDto){
        String response = enderecoService.putEndereco(id, enderecoDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDto>> pegarEnderecos(){
        List<EnderecoDto> response = enderecoService.getEnderecos();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<EnderecoDto> pegarEnderecoPorID(@PathVariable Long id){
        EnderecoDto response = enderecoService.getEnderecoById(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarEndereco(@PathVariable Long id){
        String response = enderecoService.deleteEndereco(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
