package com.example.ac1pt2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.ac1pt2.model.Categoria;
import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // Consulta para encontrar categorias cujo nome começa com a string informada
    List<Categoria> findByCategoriaNomeStartingWith(String nome);

    // Consulta para buscar uma categoria e carregar seus produtos
    @Query("SELECT c FROM Categoria c LEFT JOIN FETCH c.produtos WHERE c.id = :id")
    Categoria findByIdWithProdutos(@Param("id") Long id);
}