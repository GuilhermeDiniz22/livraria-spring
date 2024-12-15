package br.com.vendas_api.controller;

import br.com.vendas_api.dto.RegistroDto;
import br.com.vendas_api.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/registros")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @GetMapping("{id}")
    public ResponseEntity<RegistroDto> getRegistroById(@PathVariable Long id){
        RegistroDto response = registroService.getRegistroById(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
