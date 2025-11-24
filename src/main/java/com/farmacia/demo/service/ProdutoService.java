// src/main/java/com/farmacia/service/ProdutoService.java

package com.farmacia.demo.service;

import com.farmacia.demo.model.Produto;
import com.farmacia.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    // Injeção de dependência para acessar o Repository
    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Retorna a lista completa de todos os produtos.
     * @return Lista de produtos.
     */
    public List<Produto> listarTodos() {
        // O método findAll() vem do JpaRepository
        return produtoRepository.findAll();
    }
}