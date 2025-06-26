package br.com.scherer.eshop.repository;

import br.com.scherer.eshop.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    List<Cliente> findAllByAtivoTrue();

}