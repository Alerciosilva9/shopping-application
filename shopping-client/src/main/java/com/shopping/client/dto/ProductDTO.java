package com.shopping.client.dto;



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
	
	
	
	


	public ProductDTO(@NotBlank String productIdentifier, @NotBlank String nome, @NotBlank String descricao,
			@NotNull Float preco, @NotNull CategoryDTO category) {
		super();
		this.productIdentifier = productIdentifier;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.category = category;
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
