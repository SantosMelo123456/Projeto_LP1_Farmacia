package com.farmacia.demo.controller;

import com.farmacia.demo.model.Produto;
import com.farmacia.demo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos") 
public class ProdutoController {

    
    @Autowired
    private ProdutoService produtoService;

   
    @GetMapping 
    public ResponseEntity<List<Produto>> listarProdutos() {
        
        List<Produto> produtos = produtoService.listarTodos();

        
        return ResponseEntity.ok(produtos);
    }
}
