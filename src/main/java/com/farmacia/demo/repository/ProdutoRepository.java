package com.farmacia.demo.repository;
import com.farmacia.demo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Nenhum código necessário aqui para listar todos os produtos!
}
