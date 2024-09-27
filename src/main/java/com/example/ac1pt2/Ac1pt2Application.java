package com.example.ac1pt2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.ac1pt2.model.Categoria;
import com.example.ac1pt2.model.Produto;
import com.example.ac1pt2.service.CategoriaService;
import com.example.ac1pt2.service.ProdutoService;

@SpringBootApplication
public class Ac1pt2Application implements CommandLineRunner {

    private final CategoriaService categoriaService;
    private final ProdutoService produtoService;

    @Autowired
    public Ac1pt2Application(CategoriaService categoriaService, ProdutoService produtoService) {
        this.categoriaService = categoriaService;
        this.produtoService = produtoService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Ac1pt2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        // Criar e salvar categorias
        Categoria categoria1 = categoriaService.criarCategoria(new Categoria("Eletronico"));
        Categoria categoria2 = categoriaService.criarCategoria(new Categoria("Eletrodomestico"));

        // Criar e salvar produtos
        produtoService.criarProduto(new Produto("Smartphone", 1500.00, categoria1));
        produtoService.criarProduto(new Produto("Geladeira", 2500.00, categoria2));
        produtoService.criarProduto(new Produto("TV", 2000.00, categoria1));

        // Consultar produtos por preço
        List<Produto> produtosCaros = produtoService.buscarPorPrecoMaiorQue(1800.00);
        System.out.println("Produtos com preço maior que 1800: " + produtosCaros);

        List<Produto> produtosBaratos = produtoService.buscarPorPrecoMenorOuIgual(1800.00);
        System.out.println("Produtos com preço menor ou igual a 1800: " + produtosBaratos);

        List<Produto> produtosPorNome = produtoService.buscarPorNome("Smart");
        System.out.println("Produtos que começam com 'Smart': " + produtosPorNome);

        // Consultar categorias com produtos
        Categoria categoriaComProdutos = categoriaService.buscarCategoriaComProdutos(categoria1.getId());
        System.out.println("Categoria com produtos: " + categoriaComProdutos);
    }
}