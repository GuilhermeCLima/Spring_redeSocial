package com.minhaRedeSocial.RedeSocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.minhaRedeSocial.RedeSocial.model.PostagemModel;

public interface PostagemRepository extends JpaRepository<PostagemModel, Long> {
	
	public List<PostagemModel> findAllByPostContainingIgnoreCase(String post);
}
