package com.thiago.gama.banese.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.thiago.gama.banese.models.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String>{
}
