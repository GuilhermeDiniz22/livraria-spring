package br.com.vendas_api.controller;

import br.com.vendas_api.dto.SocioDtoEntrada;
import br.com.vendas_api.dto.SocioDtoSaida;
import br.com.vendas_api.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/socios")
public class SocioController {

    @Autowired
    private SocioService socioService;

    @PostMapping
    public ResponseEntity<String> novoSocio(@RequestBody  SocioDtoEntrada socioDtoEntrada){
        String response =  socioService.postSocio(socioDtoEntrada);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> atualizarSocio(@PathVariable Long id, @RequestBody  SocioDtoEntrada socioDtoEntrada){
        String response =  socioService.updateSocio(id, socioDtoEntrada);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> desativarSocio(@PathVariable Long id){
        String response =  socioService.deleteSocioById(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SocioDtoSaida>> pegarSocios(){
        List<SocioDtoSaida> response = socioService.getAllSocios();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<SocioDtoSaida> getSocio(@PathVariable Long id){
        SocioDtoSaida response = socioService.getSocioById(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("procurar-socio/nome")
    public ResponseEntity<List<SocioDtoSaida>> getSociosByNomeEemail(@RequestParam String nome){
        List<SocioDtoSaida> response = socioService.getSociosByNome(nome);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("procurar-socio/nome&email")
    public ResponseEntity<List<SocioDtoSaida>> getSociosByNomeEemail(@RequestParam String nome, @RequestParam String sobrenome){
        List<SocioDtoSaida> response = socioService.getSociosByNomeEsobrenome(nome, sobrenome);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
