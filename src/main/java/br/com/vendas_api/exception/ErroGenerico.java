package br.com.vendas_api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ErroGenerico {

    private String mensagem;

    private String path;

    private String codigo;

    private LocalDate timestamp;
}
