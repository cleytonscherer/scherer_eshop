package br.com.scherer.eshop.dto;

public record ClienteCadastro(
        String  nome,
        String  email,
        String  telefone,
        String  senha,
        String  cpf
) {
}
