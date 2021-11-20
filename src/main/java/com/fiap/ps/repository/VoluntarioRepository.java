package com.fiap.ps.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fiap.ps.model.Voluntario;

public interface VoluntarioRepository extends MongoRepository<Voluntario, String>{
	
}
