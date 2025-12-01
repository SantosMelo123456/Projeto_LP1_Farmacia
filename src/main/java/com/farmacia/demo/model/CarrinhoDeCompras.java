package com.farmacia.demo.model;

import com.farmacia.demo.enums.FormaPagamento;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Carrinho> itens;
    private FormaPagamento formaPagamento;

    // Construtor
    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    // 1. Adicionar Item
    public void adicionarItem(Carrinho item) {
        if (item != null) {
            this.itens.add(item);
        }
    }

    // 2. Calcular o Valor Total da compra automaticamente
    public double calcularValorTotal() {
        double total = 0.0;
        for (Carrinho item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    // 3. Escolher a Forma de Pagamento
    public void escolherFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    // Getters
    public List<Carrinho> getItens() {
        return itens;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void limparCarrinho() {
        this.itens.clear();
        this.formaPagamento = null;
    }
}