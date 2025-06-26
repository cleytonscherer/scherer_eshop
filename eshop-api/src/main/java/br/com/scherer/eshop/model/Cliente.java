package br.com.scherer.eshop.model;

import br.com.scherer.eshop.dto.ClienteAtualizacao;
import br.com.scherer.eshop.dto.ClienteCadastro;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.Valid;

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
    private Boolean ativo;

    public Cliente() {
    }

    public Cliente(ClienteCadastro cadastro) {
        this.id = UUID.randomUUID().toString().toUpperCase();
        this.nome = cadastro.nome();
        this.email = cadastro.email();
        this.telefone = cadastro.telefone();
        this.senha = cadastro.senha();
        this.cpf = cadastro.cpf();
        this.ativo = true;
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
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
                ",\n\tativo='" + ativo + '\'' +
                "\n}";
    }

    public void atualizar(@Valid ClienteAtualizacao dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.senha() != null) {
            this.senha = dados.senha();
        }
        if (dados.cpf() != null) {
            this.cpf = dados.cpf();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
