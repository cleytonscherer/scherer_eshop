package br.com.scherer.eshop.service;

import br.com.scherer.eshop.dto.ClienteCadastro;
import br.com.scherer.eshop.dto.ClienteDetalhe;
import br.com.scherer.eshop.model.Cliente;
import br.com.scherer.eshop.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @CacheEvict(value = "clientes", allEntries = true) // limpa o cache
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

    @Cacheable(value = "clientes") // popula o cache
    public List<ClienteDetalhe> listarTodos() {
        return clienteRepository.findAllByAtivoTrue().stream().map(ClienteDetalhe::new).toList();
    }
}
