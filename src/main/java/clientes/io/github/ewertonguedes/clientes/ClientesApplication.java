package clientes.io.github.ewertonguedes.clientes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import clientes.io.github.ewertonguedes.clientes.model.entity.Cliente;
import clientes.io.github.ewertonguedes.clientes.model.repository.ClienteRepository;

@SpringBootApplication
public class ClientesApplication {
	
	/*@Bean
	public CommandLineRunner run( @Autowired ClienteRepository repository) {
		return args -> {
			Cliente cliente = new Cliente();
			cliente.setCpf("654654654654");
			cliente.setNome("Ewerton Guedes Oliveira da Silva");
			cliente.setDataCadastro(LocalDate.now());
			
			repository.save(cliente);
		};
	}*/

	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
	}

}
