package br.com.scherer.eshop.controller;

import br.com.scherer.eshop.dto.ClienteAtualizacao;
import br.com.scherer.eshop.dto.ClienteCadastro;
import br.com.scherer.eshop.dto.ClienteDetalhe;
import br.com.scherer.eshop.model.Cliente;
import br.com.scherer.eshop.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteDetalhe> cadastrar(
            @RequestBody @Valid ClienteCadastro clienteCadastro,
            UriComponentsBuilder uriBuilder
    ) {
        Cliente cliente = service.cadastrar(clienteCadastro);
        var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDetalhe(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDetalhe> listarPorId(@PathVariable String id) {
        Cliente cliente = service.listarPorId(id);
        return ResponseEntity.ok(new ClienteDetalhe(cliente));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDetalhe>> listarTodos() {
        List<ClienteDetalhe> lista = service.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ClienteDetalhe> atualizar(@RequestBody @Valid ClienteAtualizacao dados) {
        Cliente cliente = service.listarPorId(dados.id());
        cliente.atualizar(dados);
        return ResponseEntity.ok(new ClienteDetalhe(cliente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable String id) {
        Cliente cliente = service.listarPorId(id);
        cliente.excluir();
        return ResponseEntity.noContent().build();
    }
}
