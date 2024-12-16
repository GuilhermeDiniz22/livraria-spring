package br.com.vendas_api.controller;

import br.com.vendas_api.dto.RegistroDtoSaida;
import br.com.vendas_api.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/registros")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @GetMapping("{id}")
    public ResponseEntity<RegistroDtoSaida> getRegistroById(@PathVariable Long id){
        RegistroDtoSaida response = registroService.getRegistroById(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/socio/{id}")
    public ResponseEntity<List<RegistroDtoSaida>> getRegistroBySocioId(@PathVariable Long id){
        List<RegistroDtoSaida> response = registroService.getRegistrosBySocioId(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RegistroDtoSaida>> getRegistros(){
        List<RegistroDtoSaida> response = registroService.getAllRegistros();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
