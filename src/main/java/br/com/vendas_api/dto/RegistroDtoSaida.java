package br.com.vendas_api.dto;

import br.com.vendas_api.model.Livro;
import br.com.vendas_api.model.Socio;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RegistroDtoSaida {

    private Long id;

    private String nomeLivro;

    private SocioDtoSaida socio;

    private LocalDate dataAluguel;

    private LocalDate dataEntrega;

    private Integer multa;

    public RegistroDtoSaida(Long id, String nomeLivro, SocioDtoSaida socio, LocalDate dataAluguel, LocalDate dataEntrega, Integer multa) {
        this.id = id;
        this.nomeLivro = nomeLivro;
        this.socio = socio;
        this.dataAluguel = dataAluguel;
        this.dataEntrega = dataEntrega;
        this.multa = multa;
    }

    public RegistroDtoSaida() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public SocioDtoSaida getSocio() {
        return socio;
    }

    public void setSocio(SocioDtoSaida socio) {
        this.socio = socio;
    }

    public LocalDate getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(LocalDate dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Integer getMulta() {
        return multa;
    }

    public void setMulta(Integer multa) {
        this.multa = multa;
    }
}
