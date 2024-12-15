package br.com.vendas_api.service;

import br.com.vendas_api.dto.LivroDto;
import br.com.vendas_api.dto.SocioDtoEntrada;
import br.com.vendas_api.dto.SocioDtoSaida;
import br.com.vendas_api.exception.EnderecoNaoEncontradoException;
import br.com.vendas_api.exception.LivroNaoEncontradoException;
import br.com.vendas_api.exception.SocioNaoEncontradoException;
import br.com.vendas_api.mapper.Mapper;
import br.com.vendas_api.model.Endereco;
import br.com.vendas_api.model.Livro;
import br.com.vendas_api.model.Socio;
import br.com.vendas_api.repository.EnderecoRepository;
import br.com.vendas_api.repository.SocioRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    public String deleteSocioById(Long id){
        Socio socio = socioRepository.findById(id)
                .orElseThrow(()-> new SocioNaoEncontradoException("Sócio não encontrado com id: %d", id));

        socio.setAtivo(Boolean.FALSE);

        return String.format("Sócio com id: %d deletado com sucesso!", id);
    }

    public SocioDtoSaida getSocioById(Long id){
        Socio socio = socioRepository.findById(id)
                .orElseThrow(()-> new SocioNaoEncontradoException("Sócio não encontrado com id: %d", id));

        return mapper.convertToSocioDtoSaida(socio);
    }

    public List<SocioDtoSaida> getAllSocios(){
        List<SocioDtoSaida> socios = socioRepository.findAll()
                .stream().map(mapper::convertToSocioDtoSaida)
                .collect(Collectors.toList());

        if(socios.isEmpty()){
            throw new SocioNaoEncontradoException("Nenhum sócio cadastrado!");
        }

        return socios;
    }

    public List<SocioDtoSaida> getSociosByNomeEsobrenome(String nome, String sobrenome){
        List<Socio> socios = socioRepository.findByNomeContainingIgnoreCaseAndSobrenomeContainingIgnoreCase(nome, sobrenome);

        if (socios.isEmpty()) {
            log.warn("Nenhum livro encontrado com o nome: {}", nome);
            throw new SocioNaoEncontradoException(String.format("Nenhum sócio de nome '%s' encontrado!", nome));
        }


        List<SocioDtoSaida> retorno = socios.stream()
                .map(mapper::convertToSocioDtoSaida).toList();

        return retorno;
    }

    public List<SocioDtoSaida> getSociosByNome(String nome){
        List<Socio> socios = socioRepository.findByNomeContainingIgnoreCase(nome);

        if (socios.isEmpty()) {
            log.warn("Nenhum livro encontrado com o nome: {}", nome);
            throw new SocioNaoEncontradoException(String.format("Nenhum sócio de nome '%s' encontrado!", nome));
        }


        List<SocioDtoSaida> retorno = socios.stream()
                .map(mapper::convertToSocioDtoSaida).toList();

        return retorno;
    }

    public String updateSocio(Long id, SocioDtoEntrada socioDtoEntrada){
        Socio socio = socioRepository.findById(id)
                .orElseThrow(()-> new SocioNaoEncontradoException("Sócio não encontrado com id: %d", id));

        Endereco endereco = enderecoRepository.findById(socioDtoEntrada.getEnderecoId())
                .orElseThrow(() -> new EnderecoNaoEncontradoException(
                        "Endereço com id: '%d' não encontrado!".formatted(socioDtoEntrada.getEnderecoId())));

        //pega o socio do banco e seta os valores padrão e livro (se tiver) em outro objeto do tipo socio
        Socio socio2 = new Socio();
        socio2.setLivro(socio.getLivro());
        socio2.setId(socio.getId());
        socio2.setAtivo(socio.isAtivo());
        socio2.setDataDeAdmissao(socio.getDataDeAdmissao());
        socio2.setDataDeTermino(socio.getDataDeTermino());

        //pega os dados do corpo da requisição e seta no objeto socio2
        socio2.setDataNascimento(socioDtoEntrada.getDataNascimento());
        socio2.setNome(socioDtoEntrada.getNome());
        socio2.setSobrenome(socioDtoEntrada.getSobrenome());
        socio2.setEndereco(endereco);

        // Salva as alterações no banco
        socioRepository.save(socio2);

        return String.format("Sócio com id: %d atualizado com sucesso!", id);
    }
}
