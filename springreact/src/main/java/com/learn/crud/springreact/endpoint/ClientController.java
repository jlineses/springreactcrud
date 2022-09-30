package com.learn.crud.springreact.endpoint;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.crud.springreact.model.Client;
import com.learn.crud.springreact.repository.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {

	private ClientRepository clientRepository;
	
	public ClientController(final ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	@GetMapping
	public List<Client> getAllClient(){
		return clientRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Client getById(@PathVariable final Long id) {
		return clientRepository.findById(id).orElseThrow(RuntimeException::new);
	}
	
	@PostMapping
	public ResponseEntity<Client> createClient(@RequestBody final Client client) throws URISyntaxException {
		Client newClient = clientRepository.save(client);
		return ResponseEntity.created(new URI("/clients/" + newClient.getId())).body(newClient);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable final Long id, @RequestBody final Client client)  {
		Client updateClient = clientRepository.findById(id).orElseThrow(RuntimeException::new);
		updateClient = clientRepository.save(client);
		return ResponseEntity.ok(updateClient);
	}
	
	@DeleteMapping
	public ResponseEntity deleteClient(@PathVariable final Long id) {
		clientRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}
