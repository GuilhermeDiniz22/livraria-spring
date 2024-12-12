package br.com.vendas_api.controller;

import br.com.vendas_api.dto.EnderecoDto;
import br.com.vendas_api.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<String> adicionarEndereco(@RequestBody EnderecoDto enderecoDto){
        String response = enderecoService.postEndereco(enderecoDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> atualizarEndereco(@PathVariable Long id, @RequestBody EnderecoDto enderecoDto){
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
