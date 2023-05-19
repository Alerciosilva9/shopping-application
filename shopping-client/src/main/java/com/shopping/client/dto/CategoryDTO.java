package com.shopping.client.dto;




import jakarta.validation.constraints.NotNull;

public class CategoryDTO {
	
	@NotNull
	private Long id;
	
	private String nome;
	
	
	public CategoryDTO() {
		
	}
	
	




	public CategoryDTO(@NotNull Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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