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

import com.minhaRedeSocial.RedeSocial.model.UsuarioModel;

import com.minhaRedeSocial.RedeSocial.repository.UsuarioRepository;
@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {
	@Autowired
	public UsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<UsuarioModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.badRequest().build());
	}
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<UsuarioModel>> getByDescricao(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	@PostMapping
	public ResponseEntity<UsuarioModel> post(@RequestBody UsuarioModel nome) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(nome));
	}
	@PutMapping															
	public ResponseEntity<UsuarioModel> Put(@RequestBody UsuarioModel nome){			
		return ResponseEntity.status(HttpStatus.OK) 					
				.body(repository.save(nome)); 							
	}															
	@DeleteMapping("/{id}")												
	public void Delete (@PathVariable long id) {						
		repository.deleteById(id);										
	}
}
