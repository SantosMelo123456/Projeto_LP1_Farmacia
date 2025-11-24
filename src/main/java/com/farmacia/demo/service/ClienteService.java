package com.farmacia.demo.service;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();
    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente); }

    public List<Cliente> listarClientes() {
        return clientes;
    }
    public void atualizarCliente(String nome, String novoNome) {
        for (Cliente cliente: clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                cliente.setNome(novoNome);
                System.out.println("Atualizado com sucesso!");
                return; }
        } System.out.println("Cliente não foi encontrado."); }
    public void deletarCliente(String nome) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNome().equalsIgnoreCase(nome)) {
                clientes.remove(i);
                System.out.println("Deletado com sucesso!");
                return; }
            System.out.println("Cliente não encontrado."); } }}