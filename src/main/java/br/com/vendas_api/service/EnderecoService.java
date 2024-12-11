package br.com.vendas_api.service;

import br.com.vendas_api.dto.EnderecoDto;
import br.com.vendas_api.mapper.Mapper;
import br.com.vendas_api.model.Endereco;
import br.com.vendas_api.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private Mapper mapper;

    public String postEndereco(EnderecoDto enderecoDto){

        Endereco endereco = enderecoRepository.save(mapper.convertToEndereco(enderecoDto));

        return "Endereço adicionado com sucesso!";
    }

}
