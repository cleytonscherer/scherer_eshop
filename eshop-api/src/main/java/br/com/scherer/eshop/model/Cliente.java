package br.com.scherer.eshop.model;

import br.com.scherer.eshop.dto.ClienteCadastro;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Cliente {

    @Id
    private String  id;
    private String  nome;
    private String  email;
    private String  telefone;
    private String  senha;
    private String  cpf;

    public Cliente() {
    }

    public Cliente(ClienteCadastro cadastro) {
        this.id = UUID.randomUUID().toString().toUpperCase();
        this.nome = cadastro.nome();
        this.email = cadastro.email();
        this.telefone = cadastro.telefone();
        this.senha = cadastro.senha();
        this.cpf = cadastro.cpf();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "\n------------------------------------------------------------------------------------------\n" +
                "Cliente" +
                "\n{" +
                " \n\tid='" + id + '\'' +
                ",\n\tnome='" + nome + '\'' +
                ",\n\temail='" + email + '\'' +
                ",\n\ttelefone='" + telefone + '\'' +
                ",\n\tsenha='" + senha + '\'' +
                ",\n\tcpf='" + cpf + '\'' +
                "\n}";
    }
}
