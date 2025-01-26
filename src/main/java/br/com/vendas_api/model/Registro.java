package br.com.vendas_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "registros")
@SQLRestriction("ativo = true")
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeLivro;

    @ManyToOne
    @JoinColumn(name = "socio_id", nullable = false)
    private Socio socio;

    @ManyToOne
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;

    @Column(nullable = false)
    private LocalDate dataAluguel;

    @Column
    private LocalDate dataEntrega;

    @Column
    private Integer multa;

    @Column(nullable = false)
    private boolean ativo;

    public Registro(Long id, String nomeLivro, Socio socio, Livro livro, LocalDate dataAluguel, LocalDate dataEntrega, Integer multa, boolean ativo) {
        this.id = id;
        this.nomeLivro = nomeLivro;
        this.socio = socio;
        this.livro = livro;
        this.dataAluguel = dataAluguel;
        this.dataEntrega = dataEntrega;
        this.multa = multa;
        this.ativo = ativo;
    }

    public Registro() {
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

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registro registro = (Registro) o;
        return ativo == registro.ativo && Objects.equals(id, registro.id) && Objects.equals(nomeLivro, registro.nomeLivro) && Objects.equals(socio, registro.socio) && Objects.equals(livro, registro.livro) && Objects.equals(dataAluguel, registro.dataAluguel) && Objects.equals(dataEntrega, registro.dataEntrega) && Objects.equals(multa, registro.multa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeLivro, socio, livro, dataAluguel, dataEntrega, multa, ativo);
    }
}
