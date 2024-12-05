package br.com.vendas_api.service;

import br.com.vendas_api.model.Livro;
import br.com.vendas_api.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

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
