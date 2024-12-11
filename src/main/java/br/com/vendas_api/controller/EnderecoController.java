package br.com.vendas_api.controller;

import br.com.vendas_api.dto.EnderecoDto;
import br.com.vendas_api.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
