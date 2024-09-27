package com.example.ac1pt2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ac1pt2.model.Categoria;
import com.example.ac1pt2.repository.CategoriaRepository;
import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria criarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> buscarCategoriaPorNome(String nome) {
        return categoriaRepository.findByCategoriaNomeStartingWith(nome);
    }

    public Categoria buscarCategoriaComProdutos(Long id) {
        return categoriaRepository.findByIdWithProdutos(id);
    }
}