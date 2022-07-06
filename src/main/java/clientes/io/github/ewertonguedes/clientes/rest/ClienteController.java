package clientes.io.github.ewertonguedes.clientes.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.ResponseStatus;

import clientes.io.github.ewertonguedes.clientes.model.entity.Cliente;
import clientes.io.github.ewertonguedes.clientes.model.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	

	private ClienteRepository repository;
	
	@Autowired
	public ClienteController(ClienteRepository repository) {
		this.repository = repository;
	}
	
	/*@Autowired
	public void setRepository(ClienteReposiroty repository) {
		this.repository = repository;
	}*/
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar(@RequestBody @Valid Cliente cliente) {			
		return repository.save(cliente);
	}
	
	
	@GetMapping("{id}")
	public Cliente buscaCliente( @PathVariable("id") Integer id) {
		return repository
				.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!") );		
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void DeleteCliente(@PathVariable("id") Integer id) {
		/*Metedo deletebyid resolve mas não faz verificação 
		repository.deleteById(id);*/
		
		repository
			.findById(id)
			.map( cliente ->{
				repository.delete(cliente);
				return Void.TYPE;
			})
			.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!") );
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarCliente( @PathVariable("id") Integer id, @RequestBody @Valid Cliente clienteAtualizado) {
		repository
		.findById(id)
		.map( cliente ->{
			clienteAtualizado.setId(cliente.getId());
			return repository.save(clienteAtualizado);
		})
		.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!") );
	}
		
}
