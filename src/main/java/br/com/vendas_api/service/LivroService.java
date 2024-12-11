package br.com.vendas_api.service;

import br.com.vendas_api.dto.LivroDto;
import br.com.vendas_api.exception.LivroNaoEncontradoException;
import br.com.vendas_api.mapper.Mapper;
import br.com.vendas_api.model.Livro;
import br.com.vendas_api.repository.LivroRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private Mapper mapper;

    public LivroDto getLivroById(Long id){
        Livro livro = livroRepository.findById(id).orElseThrow(()->
                new NoSuchElementException(String.format("Livro com id: %d não encontrado.", id)));

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
    public String alugarLivro(Long id){
        log.info("Buscando livro com id {}", id);

        Livro livro = livroRepository.findById(id).orElseThrow(()->
                new NoSuchElementException(String.format("Livro com id: %d não encontrado.", id)));

        if(livro.getCopiasDisponiveis() == 0){
            livro.setAtivo(Boolean.FALSE);
        }else{
            livro.setCopiasDisponiveis(livro.getCopiasDisponiveis() - 1);
        }

        return String.format("Livro '%s' alugado com sucesso! Cópias restantes: %d",
                livro.getNome(), livro.getCopiasDisponiveis());
    }

    @Transactional
    public String updateLivro(Long id, LivroDto livroAtualizado){
        log.info("Buscando livro com id {}", id);

        Livro livro = livroRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException(String.format("Livro com id: %d não encontrado.", id)));


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
                () -> new NoSuchElementException(String.format("Livro com id: %d não encontrado.", id)));

        if(!livro.isAtivo()){
            return String.format("Livro com nome '%s' já está deletado!", livro.getNome());
        }

        livro.setAtivo(Boolean.FALSE);

        return String.format("Livro com nome '%s' deletado com sucesso!", livro.getNome());

    }




}
