package com.example.ac1pt2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ac1pt2.model.Produto;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByPrecoGreaterThan(Double valor);

    List<Produto> findByPrecoLessThanEqual(Double valor);

    List<Produto> findByNomeStartingWith(String nome);
}