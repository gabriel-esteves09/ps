package com.fiap.ps.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.ps.model.Indicador;
import com.fiap.ps.repository.IndicadorRepository;


@RestController
@RequestMapping("/indicador")


public class IndicadorController {

	
	@Autowired
	private IndicadorRepository indicadorRepository;

	@PostMapping
	private ResponseEntity<Indicador> post(@RequestBody Indicador model){
		Indicador indicador = indicadorRepository.save(model);
		return new ResponseEntity<Indicador>(indicador,HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Indicador> getAll(){
		var result = indicadorRepository.findAll();
		return result;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Indicador> getById(@PathVariable String id){
		Optional<Indicador> indicador = indicadorRepository.findById(id);
		
		if(!indicador.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Indicador>(indicador.get(),HttpStatus.OK);
	}
	
	@PutMapping("/id")
	public ResponseEntity<Indicador> put(@PathVariable String id,@RequestBody Indicador model){
		Optional<Indicador> indicador = indicadorRepository.findById(id);
		
		if(!indicador.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Indicador indicadorSalvo = indicadorRepository.save(model);
		return new ResponseEntity<Indicador>(indicadorSalvo,HttpStatus.OK);
	}
}
