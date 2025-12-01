package com.farmacia.demo;

import com.farmacia.demo.model.*;
import com.farmacia.demo.controller.ClienteController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- SISTEMA DE FARMÁCIA INICIALIZADO ---");

        
        Cliente c = new Cliente();
        ClienteController  cc = new ClienteController();

        System.out.print("Digite seu nome: ");
        c.setNome( scanner.nextLine());

        System.out.print("Digite seu email: ");
        c.setEmail( scanner.nextLine());

        System.out.print("Digite sua data de nascimento (DD/MM/AAAA): ");
        c.setDataN( scanner.nextLine()); 

        System.out.print("Digite seu CPF: ");
        c.setCpf( scanner.nextLine()); 

        System.out.print("Digite seu endereço: ");
        c.setEnder( scanner.nextLine());

        System.out.print("Digite seu número de telefone (apenas números): ");
        int telefone = scanner.nextInt();
        c.setTel(telefone); 


        cc.cadastrarCliente(c);


    
        scanner.close();

        System.out.println("\n=== Preenchimento de Dados Concluído ===");

        
        System.out.println("Nome: " + c.getNome());
        System.out.println("Email: " + c.getEmail());
        System.out.println("DataN: " + c.getDataN());
        System.out.println("CPF: " + c.getCpf());
        System.out.println("Endereço: " + c.getEnder());
        System.out.println("Número de telefone: " + c.getTel());
    }
}
