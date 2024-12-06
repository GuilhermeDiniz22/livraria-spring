package br.com.vendas_api.service;

import br.com.vendas_api.dto.LivroDto;
import br.com.vendas_api.mapper.Mapper;
import br.com.vendas_api.model.Livro;
import br.com.vendas_api.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private Mapper mapper;

    public LivroDto getLivroById(Long id){
        Livro livro = livroRepository.findById(id).orElseThrow(()->
                new NoSuchElementException("Livro com id: {id} não encontrado."));

        LivroDto retorno = mapper.convertToLivroDto(livro);

        return retorno;
    }

    public List<LivroDto> getAllLivros(){
        List<Livro> livros = livroRepository.findAll().stream().sorted(Comparator.comparing(Livro::getCriadoEm))
                .toList();

        List<LivroDto> livrosRetorno = livros.stream().map(l -> mapper.convertToLivroDto(l))
                .toList();

        return livrosRetorno;
    }


    @Transactional
    public String saveLivro(Livro livro){
        Livro novoLivro = new Livro();
        novoLivro.setAutor(livro.getAutor());
        novoLivro.setCategoria(livro.getCategoria());
        novoLivro.setDescricao(livro.getDescricao());
        novoLivro.setEditora(livro.getEditora());
        novoLivro.setCopiasDisponiveis(livro.getCopiasDisponiveis());
        novoLivro.setNome(livro.getNome());
        novoLivro.setImagem(livro.getImagem());
        novoLivro.setPreco(livro.getPreco());
        novoLivro.setCriadoEm(LocalDateTime.now());

        livroRepository.save(novoLivro);

        return "Livro adicionado com sucesso!";
    }



}
