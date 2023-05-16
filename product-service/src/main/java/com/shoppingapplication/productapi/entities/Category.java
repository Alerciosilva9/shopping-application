package com.shoppingapplication.productapi.entities;

import com.shoppingapplication.productapi.dtos.CategoryDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;

	public Category() {
		
	}
	
	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public Category(CategoryDTO entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
	}
}
