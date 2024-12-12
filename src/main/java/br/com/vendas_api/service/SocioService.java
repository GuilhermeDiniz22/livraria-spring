package br.com.vendas_api.service;

import br.com.vendas_api.dto.SocioDtoEntrada;
import br.com.vendas_api.exception.EnderecoNaoEncontradoException;
import br.com.vendas_api.mapper.Mapper;
import br.com.vendas_api.model.Endereco;
import br.com.vendas_api.model.Socio;
import br.com.vendas_api.repository.EnderecoRepository;
import br.com.vendas_api.repository.SocioRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class SocioService {

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private Mapper mapper;

    @Transactional
    public String postSocio(SocioDtoEntrada socioDtoEntrada){
        Endereco endereco = enderecoRepository.findById(socioDtoEntrada.getEnderecoId()).orElseThrow(
                () -> new EnderecoNaoEncontradoException("Endereco com id: '%d' não encontrado!", socioDtoEntrada.getEnderecoId()));

        Socio socio = mapper.convertToSocio(socioDtoEntrada);
        socio.setEndereco(endereco);

        socioRepository.save(socio);

        return "Sócio salvo com sucesso!";

    }
}
