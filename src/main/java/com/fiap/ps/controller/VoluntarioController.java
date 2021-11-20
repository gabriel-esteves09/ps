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

import com.fiap.ps.model.Voluntario;
import com.fiap.ps.repository.VoluntarioRepository;

@RestController
@RequestMapping("/voluntario")

public class VoluntarioController {

	@Autowired
	private VoluntarioRepository voluntarioRepository;

	@PostMapping
	private ResponseEntity<Voluntario> post(@RequestBody Voluntario model){
		Voluntario voluntario = voluntarioRepository.save(model);
		return new ResponseEntity<Voluntario>(voluntario,HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Voluntario> getAll(){
		var result = voluntarioRepository.findAll();
		return result;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Voluntario> getById(@PathVariable String id){
		Optional<Voluntario> voluntario = voluntarioRepository.findById(id);
		
		if(!voluntario.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Voluntario>(voluntario.get(),HttpStatus.OK);
	}
	
	@PutMapping("/id")
	public ResponseEntity<Voluntario> put(@PathVariable String id,@RequestBody Voluntario model){
		Optional<Voluntario> voluntario = voluntarioRepository.findById(id);
		
		if(!voluntario.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Voluntario voluntarioSalvo = voluntarioRepository.save(model);
		return new ResponseEntity<Voluntario>(voluntarioSalvo,HttpStatus.OK);
	}
	
	
}
