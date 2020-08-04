package com.minhaRedeSocial.RedeSocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minhaRedeSocial.RedeSocial.model.UsuarioModel;



public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{
	
	public List<UsuarioModel> findAllByNomeContainingIgnoreCase(String nome);
}
