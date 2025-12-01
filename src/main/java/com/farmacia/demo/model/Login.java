package com.farmacia.demo.model;

public class Login { // <-- CORREÇÃO: ADICIONAMOS 'class'

    private String nome;
    private String email;
    private String senha;

    // Construtor vazio (boas práticas)
    public Login() {
    }

    // --- Getters e Setters (com corpos de método) ---

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}