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

import com.minhaRedeSocial.RedeSocial.model.PostagemModel;
import com.minhaRedeSocial.RedeSocial.repository.PostagemRepository;

@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")
public class PostagemController {

	@Autowired
	public PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<PostagemModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<PostagemModel> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.badRequest().build());
	}
	@GetMapping("/post/{post}")
	public ResponseEntity<List<PostagemModel>> getByDescricao(@PathVariable String post){
		return ResponseEntity.ok(repository.findAllByPostContainingIgnoreCase(post));
	}
	@PostMapping
	public ResponseEntity<PostagemModel> post(@RequestBody PostagemModel post) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(post));
	}
	@PutMapping															
	public ResponseEntity<PostagemModel> Put(@RequestBody PostagemModel post){			
		return ResponseEntity.status(HttpStatus.OK) 					
				.body(repository.save(post)); 							
	}															
	@DeleteMapping("/{id}")												
	public void Delete (@PathVariable long id) {						
		repository.deleteById(id);										
	}
}
