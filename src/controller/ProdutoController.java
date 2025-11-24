// src/main/java/com/farmacia/controller/ProdutoController.java

package com.farmacia.controller;

import com.farmacia.model.Produto;
import com.farmacia.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos") // Mapeamento da URL base para este controller
public class ProdutoController {

    // Injeção de dependência para acessar o Service
    @Autowired
    private ProdutoService produtoService;

    /**
     * Endpoint para listar todos os produtos.
     * Mapeado para GET http://localhost:8080/produtos
     * @return ResponseEntity com a lista de produtos e status HTTP 200 (OK).
     */
    @GetMapping // Mapeia requisições GET para a URL base /produtos
    public ResponseEntity<List<Produto>> listarProdutos() {
        // 1. Chama o Service
        List<Produto> produtos = produtoService.listarTodos();

        // 2. Retorna a lista com o status HTTP 200 (OK)
        return ResponseEntity.ok(produtos);
    }
}