package com.farmacia.demo.controller;

import com.farmacia.demo.enums.FormaPagamento;
import com.farmacia.demo.model.CarrinhoDeCompras;
import com.farmacia.demo.model.Carrinho;
import com.farmacia.demo.model.FinalizacaoCompra;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    // Simulação: Injetando o carrinho. No mundo real, você usaria um Service
    // e o escopo da sessão para gerenciar o carrinho de cada usuário.
    private final CarrinhoDeCompras carrinho;

    public CarrinhoController() {
        this.carrinho = new CarrinhoDeCompras();
    }

    // POST /carrinho/adicionar
    // Adiciona um novo item ao carrinho.
    @PostMapping("/adicionar")
    public CarrinhoDeCompras adicionarItem(@RequestBody Carrinho item) {
        carrinho.adicionarItem(item);
        return carrinho; // Retorna o estado atual do carrinho
    }

    // GET /carrinho/total
    // Retorna o valor total da compra.
    @GetMapping("/total")
    public double getTotal() {
        return carrinho.calcularValorTotal();
    }

    // GET /carrinho/info
    // Retorna todos os detalhes do carrinho.
    @GetMapping("/info")
    public CarrinhoDeCompras getCarrinho() {
        return carrinho;
    }

    // POST /carrinho/pagamento?forma=PIX
    // Escolhe a forma de pagamento.
    @PostMapping("/pagamento")
    public String escolherPagamento(@RequestParam FormaPagamento forma) {
        carrinho.escolherFormaPagamento(forma);
        double total = carrinho.calcularValorTotal();
        return String.format("Forma de pagamento escolhida: %s. Valor total: R$ %.2f", forma.name(), total);
    }

    @PostMapping("/finalizar")
    public String finalizarCompra(@RequestBody FinalizacaoCompra finalizacaoInfo) {

        // 1. Pré-validação do Carrinho
        double total = carrinho.calcularValorTotal();

        if (carrinho.getItens().isEmpty()) {
            return "Erro: O carrinho está vazio. Adicione itens antes de finalizar.";
        }

        if (carrinho.getFormaPagamento() == null) {
            return "Erro: Selecione uma forma de pagamento antes de finalizar.";
        }

        // 2. Simulação de Confirmação de Login

        // Simulação de validação de nome obrigatório
        if (finalizacaoInfo.getNome() == null || finalizacaoInfo.getNome().isEmpty()) {
            return "Erro: O nome do cliente é obrigatório para finalizar a compra.";
        }

        // Simulação de validação de senha:
        // *SUBSTITUA "sua-senha-segura" pela sua lógica real de login e hashing de senha.*
        if (!finalizacaoInfo.getSenha().equals("sua-senha-segura")) {
            return "Erro: Senha inválida para o cliente " + finalizacaoInfo.getNome();
        }

        // 3. Processamento da Transação

        String recibo = String.format(
                "Compra #12345 finalizada com sucesso!\nCliente: %s\nTotal Pago: R$ %.2f\nForma de Pagamento: %s\nObrigado por comprar!",
                finalizacaoInfo.getNome(),
                total,
                carrinho.getFormaPagamento().name()
        );

        // 4. Limpar o carrinho após a finalização
        carrinho.limparCarrinho();

        return recibo;
    }

}