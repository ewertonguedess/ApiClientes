package clientes.io.github.ewertonguedes.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import clientes.io.github.ewertonguedes.clientes.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
