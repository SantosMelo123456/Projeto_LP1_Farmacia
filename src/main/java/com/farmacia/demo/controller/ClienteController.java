package com.farmacia.demo.controller;

import com.farmacia.demo.model.Cliente;
import com.farmacia.demo.service.ClienteService;

import java.util.List;

public class ClienteController {
    private ClienteService clienteService = new ClienteService();

    public void cadastrarCliente(Cliente c) {

        clienteService.cadastrarCliente(c);
    }
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }
    public void atualizarCliente(String nome, String novoNome) {
        clienteService.atualizarCliente(nome, novoNome);
    }
    public void deletarCliente(String nome) {
        clienteService.deletarCliente(nome);
    }
}