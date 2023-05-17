package com.shopping.client.dto;




import com.shoppingapplication.productapi.entities.Category;
import jakarta.validation.constraints.NotNull;

public class CategoryDTO {
	
	@NotNull
	private Long id;
	
	private String nome;
	
	
	public CategoryDTO() {
		
	}
	
	
	public CategoryDTO(Category entity){
		this.id = entity.getId();
		this.nome = entity.getNome();
	}



	public Long getId() {
		return id;
	}



	public String getNome() {
		return nome;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}