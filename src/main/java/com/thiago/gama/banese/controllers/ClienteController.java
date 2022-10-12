package com.thiago.gama.banese.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiago.gama.banese.models.Cliente;
import com.thiago.gama.banese.repositories.ClienteRepository;

@RestController
@RequestMapping("/service")
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> getClientes(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/cliente/{id}")
	public Cliente getCliente(@PathVariable String id){
		return clienteRepository.findById(id).orElse(null);
	}
	
	@PostMapping("/cliente")
	public Cliente addCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/cliente")
	public Cliente putCliente(@RequestBody Cliente novoCliente) {
		Cliente antigoCliente = clienteRepository.findById(novoCliente.getId()).orElse(null);
		antigoCliente.setNome(novoCliente.getNome());
		antigoCliente.setEmail(novoCliente.getEmail());
		antigoCliente.setSenha(novoCliente.getSenha());
		return antigoCliente;
	}
	
	@DeleteMapping("/cliente/{id}")
	public String deleteCliente(@PathVariable String id) {
		clienteRepository.deleteById(id);
		return id;
	}
}
