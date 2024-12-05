package br.com.vendas_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "registros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


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
}
