package controller;

import model.Cliente;
import service.ClienteService;

public class ClienteController {
    private ClienteService clienteService = new ClienteService();

    public void cadastrarCliente(Cliente cliente) {

        clienteService.cadastrarCliente(cliente);
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