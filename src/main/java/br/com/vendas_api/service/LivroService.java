package br.com.vendas_api.service;

import br.com.vendas_api.dto.LivroDto;
import br.com.vendas_api.exception.LivroNaoEncontradoException;
import br.com.vendas_api.exception.RegistroNaoEncontradoException;
import br.com.vendas_api.exception.SocioNaoEncontradoException;
import br.com.vendas_api.mapper.Mapper;
import br.com.vendas_api.model.Livro;
import br.com.vendas_api.model.Registro;
import br.com.vendas_api.model.Socio;
import br.com.vendas_api.repository.LivroRepository;
import br.com.vendas_api.repository.RegistroRepository;
import br.com.vendas_api.repository.SocioRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private RegistroRepository registroRepository;

    @Autowired
    private Mapper mapper;

    public LivroDto getLivroById(Long id){
        log.info(String.format("Buscando livro com id: '%d", id));

        Livro livro = livroRepository.findById(id).orElseThrow(()->
                new LivroNaoEncontradoException("Livro com id: " + id + " não encontrado."));

        LivroDto retorno = mapper.convertToLivroDto(livro);

        return retorno;
    }

    public List<LivroDto> getAllLivros(){
        log.info("Buscando livros");
        List<Livro> livros = livroRepository.findAll().stream().sorted(Comparator.comparing(Livro::getCriadoEm))
                .toList();

        if(livros.isEmpty()){
            throw new LivroNaoEncontradoException("Nenhum livro encontrado!");
        }

        List<LivroDto> livrosRetorno = livros.stream().map(mapper::convertToLivroDto)
                .toList();

        return livrosRetorno;
    }

    public List<LivroDto> getLivrosByNomeEAutorContaining(String nome, String autor){
        List<Livro> livros = livroRepository.findByNomeContainingIgnoreCaseAndAutorContainingIgnoreCase(nome, autor);

        if (livros.isEmpty()) {
            log.warn("Nenhum livro encontrado com o nome: {}", nome);
            throw new LivroNaoEncontradoException(String.format("Nenhum livro de nome '%s' encontrado!", nome));
        }


        List<LivroDto> retorno = livros.stream()
                .map(mapper::convertToLivroDto).toList();

        return retorno;

    }


    public List<LivroDto> getLivrosByNomeContaining(String nome){
        List<Livro> livros = livroRepository.findByNomeIgnoreCaseContaining(nome);

        if (livros.isEmpty()) {
            log.warn("Nenhum livro encontrado com o nome: {}", nome);
            throw new LivroNaoEncontradoException(String.format("Nenhum livro de nome '%s' encontrado!", nome));
        }


        List<LivroDto> retorno = livros.stream()
                .map(mapper::convertToLivroDto).toList();

        return retorno;

    }

    @Transactional
    public String alugarLivro(Long socioId, Long livroId){
        log.info("Buscando livro com id {}", livroId);

        Livro livro = livroRepository.findById(livroId).orElseThrow(()->
                new LivroNaoEncontradoException(String.format("Livro com id: %d não encontrado.", livroId)));

        Socio socio = socioRepository.findById(socioId)
                .orElseThrow(()->
                        new NoSuchElementException(String.format("Socio com id: %d não encontrado.", socioId)));

        if(socio.getLivro() != null) throw new IllegalArgumentException("O sócio já alugou um livro!");

        socio.setLivro(livro);

        if(livro.getCopiasDisponiveis() == 0){
            livro.setAtivo(Boolean.FALSE);

            return "Livro não disponível!";

        }else{
            livro.setCopiasDisponiveis(livro.getCopiasDisponiveis() - 1);

            socioRepository.save(socio);
        }

        Registro registro = new Registro();
        registro.setDataAluguel(LocalDate.now());
        registro.setSocio(socio);
        registro.setNomeLivro(livro.getNome());
        registro.setLivro(livro);
        registro.setAtivo(Boolean.TRUE);

        Registro novo = registroRepository.save(registro);

        return String.format("Livro '%s' alugado com sucesso! Cópias restantes: %d e Registro criado com sucesso com id: %d",
                livro.getNome(), livro.getCopiasDisponiveis(), novo.getId());
    }

    @Transactional
    public String devolverLivro(Long socioId, Long livroId) {
        log.info("Buscando livro com id {}", livroId);

        Livro livro = livroRepository.findById(livroId).orElseThrow(() ->
                new LivroNaoEncontradoException(String.format("Livro com id: %d não encontrado.", livroId)));


        Socio socio = socioRepository.findById(socioId).orElseThrow(() ->
                new NoSuchElementException(String.format("Socio com id: %d não encontrado.", socioId)));

        Registro registro = registroRepository.findBySocioIdAndAtivoTrue(socio.getId());

        if (registro == null || !registro.isAtivo()) {
            throw new RegistroNaoEncontradoException(String.format("Nenhum registro ativo encontrado para o sócio com ID %d.", socioId));
        }

        registro.setDataEntrega(LocalDate.now());

        long diferencaEmDias = ChronoUnit.DAYS.between(registro.getDataAluguel(), registro.getDataEntrega());

        if (diferencaEmDias > 20) {
            int multaPorDia = 2; // Exemplo: R$2 por dia de atraso
            int diasAtraso = (int) (diferencaEmDias - 20);
            registro.setMulta(diasAtraso * multaPorDia);
        } else {
            registro.setMulta(0); // Sem multa
        }

        registro.setAtivo(Boolean.FALSE);


        if (socio.getLivro() == null || !socio.getLivro().getId().equals(livroId))
            throw new IllegalArgumentException(String.format("O sócio de id: %d não alugou o livro com id: %d.", socioId, livroId));


        socio.setLivro(null);

        livro.setCopiasDisponiveis(livro.getCopiasDisponiveis() + 1);

        if (!livro.isAtivo() && livro.getCopiasDisponiveis() > 0)
            livro.setAtivo(Boolean.TRUE);


        livroRepository.save(livro);
        socioRepository.save(socio);
        registroRepository.save(registro);

        return String.format("Livro '%s' devolvido com sucesso! Cópias restantes: %d e Registro deletado com sucesso com id: %d",
                livro.getNome(), livro.getCopiasDisponiveis(), registro.getId());
    }

    @Transactional
    public String updateLivro(Long id, LivroDto livroAtualizado){
        log.info("Buscando livro com id {}", id);

        Livro livro = livroRepository.findById(id).orElseThrow(
                () -> new LivroNaoEncontradoException(String.format("Livro com id: %d não encontrado.", id)));


        livro.setAutor(livroAtualizado.getAutor());
        livro.setEditora(livroAtualizado.getEditora());
        livro.setNome(livroAtualizado.getNome());
        livro.setImagem(livroAtualizado.getImagem());
        livro.setCategoria(livroAtualizado.getCategoria());
        livro.setCopiasDisponiveis(livroAtualizado.getCopiasDisponiveis());
        livro.setDescricao(livroAtualizado.getDescricao());


        Livro livroBanco = livroRepository.save(livro);

        return String.format("Livro com id: %d atualizado com sucesso!.", id);
    }


    @Transactional
    public String saveLivro(LivroDto livro){
        Livro novoLivro = mapper.convertToLivro(livro);

        livroRepository.save(novoLivro);

        return "Livro adicionado com sucesso!";
    }

    @Transactional
    public String deleteLivro(Long id){

        log.info("Buscando livro com id {}", id);

        Livro livro = livroRepository.findById(id).orElseThrow(
                () -> new LivroNaoEncontradoException(String.format("Livro com id: %d não encontrado.", id)));

        if(!livro.isAtivo()){
            return String.format("Livro com nome '%s' já está deletado!", livro.getNome());
        }

        livro.setAtivo(Boolean.FALSE);

        return String.format("Livro com nome '%s' deletado com sucesso!", livro.getNome());

    }



}
