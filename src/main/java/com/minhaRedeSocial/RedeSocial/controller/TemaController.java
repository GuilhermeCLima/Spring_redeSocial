package com.minhaRedeSocial.RedeSocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minhaRedeSocial.RedeSocial.model.TemaModel;
import com.minhaRedeSocial.RedeSocial.repository.TemaRepository;
@RestController
@RequestMapping("/tema")
@CrossOrigin("*")
public class TemaController {

	@Autowired
	public TemaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<TemaModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TemaModel> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.badRequest().build());
	}
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<TemaModel>> getByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	@PostMapping
	public ResponseEntity<TemaModel> post(@RequestBody TemaModel descricao) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(descricao));
	}
	@PutMapping															
	public ResponseEntity<TemaModel> Put(@RequestBody TemaModel descricao){			
		return ResponseEntity.status(HttpStatus.OK) 					
				.body(repository.save(descricao)); 							
	}															
	@DeleteMapping("/{id}")												
	public void Delete (@PathVariable long id) {						
		repository.deleteById(id);										
	}
}
