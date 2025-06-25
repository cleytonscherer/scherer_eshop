package br.com.scherer.eshop.controller;

import br.com.scherer.eshop.dto.ClienteCadastro;
import br.com.scherer.eshop.dto.ClienteDetalhe;
import br.com.scherer.eshop.model.Cliente;
import br.com.scherer.eshop.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteDetalhe> cadastrar(@RequestBody ClienteCadastro clienteCadastro) {
        Cliente cliente = service.cadastrar(clienteCadastro);
        return ResponseEntity.ok(new ClienteDetalhe(cliente));
    }
}
