package com.example.ac1pt2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ac1pt2.model.Produto;
import com.example.ac1pt2.repository.ProdutoRepository;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> buscarPorPrecoMaiorQue(Double preco) {
        return produtoRepository.findByPrecoGreaterThan(preco);
    }

    public List<Produto> buscarPorPrecoMenorOuIgual(Double preco) {
        return produtoRepository.findByPrecoLessThanEqual(preco);
    }

    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNomeStartingWith(nome);
    }
}