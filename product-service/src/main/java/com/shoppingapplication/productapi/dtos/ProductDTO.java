package com.shoppingapplication.productapi.dtos;

import com.shoppingapplication.productapi.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDTO {
	
	@NotBlank
	private String productIdentifier;

	@NotBlank 
	private String nome;
	
	@NotBlank
	private String descricao;
	
	@NotNull
	private Float preco;
	
	@NotNull
	private CategoryDTO category;
	
	
	public ProductDTO(){
		
	}
	
	public ProductDTO(Product entity){
		this.nome = entity.getNome();
		this.preco = entity.getPreco();
		this.productIdentifier = entity.getIdentifier();
		this.descricao = entity.getDescricao();
		if (entity.getCategory() != null){
			this.category = new CategoryDTO(entity.getCategory());
		}
		
	}


	public String getProductIdentifier() {
		return productIdentifier;
	}


	public String getNome() {
		return nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public Float getPreco() {
		return preco;
	}


	public CategoryDTO getCategory() {
		return category;
	}


	public void setProductIdentifier(String productIdentifier) {
		this.productIdentifier = productIdentifier;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public void setPreco(Float preco) {
		this.preco = preco;
	}


	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
	
	
	
}
