package br.com.vendas_api.service;

import br.com.vendas_api.dto.RegistroDto;
import br.com.vendas_api.exception.RegistroNaoEncontradoException;
import br.com.vendas_api.mapper.Mapper;
import br.com.vendas_api.model.Registro;
import br.com.vendas_api.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository registroRepository;

    @Autowired
    private Mapper mapper;

    public RegistroDto getRegistroById(Long id){
        Registro registro = registroRepository.findById(id)
                .orElseThrow(
                        ()-> new RegistroNaoEncontradoException(String.format("Registro não encontrado com id: %d", id)));

        return mapper.converToRegistroDto(registro);
    }
}
