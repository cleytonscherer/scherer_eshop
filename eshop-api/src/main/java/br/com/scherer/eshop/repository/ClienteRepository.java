package br.com.scherer.eshop.repository;

import br.com.scherer.eshop.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
