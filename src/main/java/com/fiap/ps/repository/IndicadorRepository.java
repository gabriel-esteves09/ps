package com.fiap.ps.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fiap.ps.model.Indicador;

public interface IndicadorRepository extends MongoRepository<Indicador, String>{
	
	

}
