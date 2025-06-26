package br.com.scherer.eshop.dto;

import br.com.scherer.eshop.model.Cliente;

import java.io.Serializable;


public record ClienteDetalhe(
        String  id,
        String  nome,
        String  email,
        String  telefone,
        String  cpf
) implements Serializable {
    public ClienteDetalhe(Cliente cliente) {
        this(   cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getCpf()
        );
    }
}
