package br.com.scherer.eshop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ClienteAtualizacao(
        @NotBlank
        String  id,
        @NotBlank(message = "Nome do cliente deve ser informado")
        String  nome,
        @NotBlank(message = "endereço de e-mail deve ser informado")
        @Email(message = "Formato de endereço de e-mail inválido")
        String  email,
        @NotBlank(message = "Número de telefone deve ser informado")
        String  telefone,
        @NotBlank(message = "Senha deve ser informada")
        String  senha,
        @NotBlank
//        @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)", message = "Formato do CPF inválido")
        @Pattern(regexp = "^((\\d{3}).(\\d{3}).(\\d{3})-(\\d{2}))*$", message = "Formato do CPF inválido")
        String  cpf
) {
}
