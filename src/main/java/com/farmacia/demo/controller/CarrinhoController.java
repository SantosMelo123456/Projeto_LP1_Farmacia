package com.farmacia.demo.controller;

import com.farmacia.demo.enums.FormaPagamento;
import com.farmacia.demo.model.CarrinhoDeCompras;
import com.farmacia.demo.model.Carrinho;
import com.farmacia.demo.model.FinalizacaoCompra;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    
    private final CarrinhoDeCompras carrinho;

    public CarrinhoController() {
        this.carrinho = new CarrinhoDeCompras();
    }

    
    @PostMapping("/adicionar")
    public CarrinhoDeCompras adicionarItem(@RequestBody Carrinho item) {
        carrinho.adicionarItem(item);
        return carrinho; 
    }

    
    @GetMapping("/total")
    public double getTotal() {
        return carrinho.calcularValorTotal();
    }

    
    @GetMapping("/info")
    public CarrinhoDeCompras getCarrinho() {
        return carrinho;
    }

    
    @PostMapping("/pagamento")
    public String escolherPagamento(@RequestParam FormaPagamento forma) {
        carrinho.escolherFormaPagamento(forma);
        double total = carrinho.calcularValorTotal();
        return String.format("Forma de pagamento escolhida: %s. Valor total: R$ %.2f", forma.name(), total);
    }

    @PostMapping("/finalizar")
    public String finalizarCompra(@RequestBody FinalizacaoCompra finalizacaoInfo) {

        
        double total = carrinho.calcularValorTotal();

        if (carrinho.getItens().isEmpty()) {
            return "Erro: O carrinho está vazio. Adicione itens antes de finalizar.";
        }

        if (carrinho.getFormaPagamento() == null) {
            return "Erro: Selecione uma forma de pagamento antes de finalizar.";
        }

        
        if (finalizacaoInfo.getNome() == null || finalizacaoInfo.getNome().isEmpty()) {
            return "Erro: O nome do cliente é obrigatório para finalizar a compra.";
        }

        
        if (!finalizacaoInfo.getSenha().equals("sua-senha-segura")) {
            return "Erro: Senha inválida para o cliente " + finalizacaoInfo.getNome();
        }

       

        String recibo = String.format(
                "Compra #12345 finalizada com sucesso!\nCliente: %s\nTotal Pago: R$ %.2f\nForma de Pagamento: %s\nObrigado por comprar!",
                finalizacaoInfo.getNome(),
                total,
                carrinho.getFormaPagamento().name()
        );

        
        carrinho.limparCarrinho();

        return recibo;
    }

}
