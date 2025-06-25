package br.com.scherer.eshop.service;

import br.com.scherer.eshop.dto.ClienteCadastro;
import br.com.scherer.eshop.model.Cliente;
import br.com.scherer.eshop.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente cadastrar(ClienteCadastro cadastro) {
        Cliente cliente = new Cliente(cadastro);
        clienteRepository.save(cliente);

        System.out.println(cliente);
        return cliente;
    }

    public Cliente listarPorId(String id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new RuntimeException();
        }
        return cliente.get();
    }


}
