// Localização: src/model/impl/ClienteImpl.java

package model;
/**
 * Implementação concreta da interface Cliente.
 */
public class Cliente {

    private String nome;
    private String email;
    private String dataN;
    private String cpf;
    private String ender;
    private int tel;

    // Construtor padrão (opcional, mas boa prática)
    public Cliente() {
    }

    // ==========================================================
    // Implementação dos Getters
    // ==========================================================


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

    public String getDataN() {
        return dataN;
    }

    public void setDataN(String dataN) {
        this.dataN = dataN;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEnder() {
        return ender;
    }

    public void setEnder(String ender) {
        this.ender = ender;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
}