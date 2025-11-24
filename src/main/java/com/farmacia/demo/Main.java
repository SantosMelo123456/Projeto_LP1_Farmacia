package com.farmacia.demo;

import com.farmacia.demo.model.*;
import controller.ClienteController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicializa o Scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- SISTEMA DE FARMÁCIA INICIALIZADO ---");

        // Inicializa o objeto ClienteImpl (corrigido)
        Cliente c = new Cliente();
        ClienteController  cc = new ClienteController();

        System.out.print("Digite seu nome: ");
        c.setNome( scanner.nextLine());

        System.out.print("Digite seu email: ");
        c.setEmail( scanner.nextLine());

        System.out.print("Digite sua data de nascimento (DD/MM/AAAA): ");
        c.setDataN( scanner.nextLine()); // Lendo como String

        System.out.print("Digite seu CPF: ");
        c.setCpf( scanner.nextLine()); // Lendo como String

        System.out.print("Digite seu endereço: ");
        c.setEnder( scanner.nextLine());

        System.out.print("Digite seu número de telefone (apenas números): ");
        int telefone = scanner.nextInt();
        c.setTel(telefone); // Lendo como int


        cc.cadastrarCliente(c);


        // Opcional: fechar o scanner
        scanner.close();

        System.out.println("\n=== Preenchimento de Dados Concluído ===");

        // Note que o casting não é necessário se 'a' for declarado como ClienteImpl
        System.out.println("Nome: " + c.getNome());
        System.out.println("Email: " + c.getEmail());
        System.out.println("DataN: " + c.getDataN());
        System.out.println("CPF: " + c.getCpf());
        System.out.println("Endereço: " + c.getEnder());
        System.out.println("Número de telefone: " + c.getTel());
    }
}