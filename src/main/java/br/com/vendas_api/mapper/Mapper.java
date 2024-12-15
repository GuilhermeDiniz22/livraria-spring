package br.com.vendas_api.mapper;

import br.com.vendas_api.dto.*;
import br.com.vendas_api.model.Endereco;
import br.com.vendas_api.model.Livro;
import br.com.vendas_api.model.Registro;
import br.com.vendas_api.model.Socio;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Component
public class Mapper {

    public LivroDto convertToLivroDto(Livro livro){
        LivroDto livroDto = new LivroDto();

        livroDto.setId((livro.getId()));
        livroDto.setNome(livro.getNome());
        livroDto.setPreco(livro.getPreco());
        livroDto.setImagem(livro.getImagem());
        livroDto.setEditora(livro.getEditora());
        livroDto.setDescricao(livro.getDescricao());
        livroDto.setAutor(livro.getAutor());
        livroDto.setCopiasDisponiveis(livro.getCopiasDisponiveis());
        livroDto.setCategoria(livro.getCategoria());

        return livroDto;

    }

    public Livro convertToLivro(LivroDto livro){
        Livro livroNovo = new Livro();

        livroNovo.setId((livro.getId()));
        livroNovo.setNome(livro.getNome());
        livroNovo.setPreco(livro.getPreco());
        livroNovo.setImagem(livro.getImagem());
        livroNovo.setEditora(livro.getEditora());
        livroNovo.setDescricao(livro.getDescricao());
        livroNovo.setAutor(livro.getAutor());
        livroNovo.setCopiasDisponiveis(livro.getCopiasDisponiveis());
        livroNovo.setCategoria(livro.getCategoria());
        livroNovo.setAtivo(Boolean.TRUE);

        return livroNovo;

    }

    public Endereco convertToEndereco(EnderecoDto parametro) {
        Endereco endereco = new Endereco();
        endereco.setId(parametro.getId());
        endereco.setRua(parametro.getRua());
        endereco.setNumero(parametro.getNumero());
        endereco.setCep(parametro.getCep());
        endereco.setBairro(parametro.getBairro());
        endereco.setComplemento(parametro.getComplemento());
        endereco.setAtivo(Boolean.TRUE);

        return endereco;
    }

    public EnderecoDto convertToEnderecoDto(Endereco parametro) {
        EnderecoDto endereco = new EnderecoDto();
        endereco.setId(parametro.getId());
        endereco.setRua(parametro.getRua());
        endereco.setNumero(parametro.getNumero());
        endereco.setCep(parametro.getCep());
        endereco.setBairro(parametro.getBairro());
        endereco.setComplemento(parametro.getComplemento());

        return endereco;
    }

    public Socio convertToSocio(SocioDtoEntrada socioDtoEntrada){
        Socio socio = new Socio();

        socio.setNome(socioDtoEntrada.getNome());
        socio.setSobrenome(socioDtoEntrada.getSobrenome());
        socio.setEmail(socioDtoEntrada.getEmail());
        socio.setDataNascimento(socioDtoEntrada.getDataNascimento());
        socio.setDataDeAdmissao(LocalDate.now());
        socio.setAtivo(Boolean.TRUE);

        return socio;
    }

    public SocioDtoSaida convertToSocioDtoSaida(Socio socio){
        SocioDtoSaida saida = new SocioDtoSaida();

        saida.setId(socio.getId());
        saida.setEmail(socio.getEmail());
        saida.setNome(socio.getNome());
        saida.setSobrenome(socio.getSobrenome());
        saida.setDataNascimento(socio.getDataNascimento());
        saida.setDataDeAdmissao(socio.getDataDeAdmissao());
        saida.setEndereco(convertToEnderecoDto(socio.getEndereco()));
        saida.setLivro(socio.getLivro() != null ? convertToLivroDto(socio.getLivro()) : getLivroVazio());

        return saida;
    }

    private LivroDto getLivroVazio() {
        return new LivroDto();
    }

    public RegistroDto converToRegistroDto(Registro registro){
        RegistroDto retorno = new RegistroDto();
        retorno.setSocio(registro.getSocio());
        retorno.setId(registro.getId());
        retorno.setLivro(registro.getLivro());
        retorno.setDataAluguel(registro.getDataAluguel());
        retorno.setMulta(registro.getMulta());
        retorno.setDataEntrega(registro.getDataEntrega());

        return retorno;
    }
}
