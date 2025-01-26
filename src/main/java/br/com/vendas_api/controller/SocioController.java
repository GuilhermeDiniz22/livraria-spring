package br.com.vendas_api.controller;

import br.com.vendas_api.dto.SocioDtoEntrada;
import br.com.vendas_api.dto.SocioDtoSaida;
import br.com.vendas_api.service.SocioService;
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
@RequestMapping("api/socios")
@Tag(
        name = "API Sócios",
        description = "API responsável pelos serviços da entidade Sócio no sistema."
)
public class SocioController {

    @Autowired
    private SocioService socioService;

    @PostMapping
    @Operation(
            summary = "Cadastrar um novo sócio",
            description = "Recebe os dados de entrada para criar um novo sócio no sistema."
    )
    public ResponseEntity<String> novoSocio(@Valid @RequestBody SocioDtoEntrada socioDtoEntrada) {
        String response = socioService.postSocio(socioDtoEntrada);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("{id}")
    @Operation(
            summary = "Atualizar informações de um sócio",
            description = "Atualiza os dados de um sócio existente identificado pelo ID."
    )
    public ResponseEntity<String> atualizarSocio(@PathVariable Long id, @Valid @RequestBody SocioDtoEntrada socioDtoEntrada) {
        String response = socioService.updateSocio(id, socioDtoEntrada);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @Operation(
            summary = "Desativar um sócio",
            description = "Desativa um sócio no sistema identificado pelo ID fornecido."
    )
    public ResponseEntity<String> desativarSocio(@PathVariable Long id) {
        String response = socioService.deleteSocioById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    @Operation(
            summary = "Listar todos os sócios",
            description = "Retorna uma lista com todos os sócios cadastrados no sistema."
    )
    public ResponseEntity<List<SocioDtoSaida>> pegarSocios() {
        List<SocioDtoSaida> response = socioService.getAllSocios();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Obter detalhes de um sócio",
            description = "Retorna os dados de um sócio específico identificado pelo ID."
    )
    public ResponseEntity<SocioDtoSaida> getSocio(@PathVariable Long id) {
        SocioDtoSaida response = socioService.getSocioById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("procurar-socio/nome")
    @Operation(
            summary = "Buscar sócios por nome",
            description = "Retorna uma lista de sócios cujo nome contém o valor fornecido."
    )
    public ResponseEntity<List<SocioDtoSaida>> getSociosByNome(@RequestParam String nome) {
        List<SocioDtoSaida> response = socioService.getSociosByNome(nome);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("procurar-socio/nome&email")
    @Operation(
            summary = "Buscar sócios por nome e sobrenome",
            description = "Retorna uma lista de sócios que correspondem ao nome e sobrenome fornecidos."
    )
    public ResponseEntity<List<SocioDtoSaida>> getSociosByNomeEemail(@RequestParam String nome, @RequestParam String sobrenome) {
        List<SocioDtoSaida> response = socioService.getSociosByNomeEsobrenome(nome, sobrenome);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
