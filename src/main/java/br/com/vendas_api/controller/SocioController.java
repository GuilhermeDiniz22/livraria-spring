package br.com.vendas_api.controller;

import br.com.vendas_api.dto.SocioDtoEntrada;
import br.com.vendas_api.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
