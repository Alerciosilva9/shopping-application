package com.shopping.client.dto;



import jakarta.validation.constraints.NotNull;

public class UserDTO {

	
	private long id;
	
	//@NotEmpty
	@NotNull
	private String nome;
	@NotNull
	private String cpf;
	@NotNull
	private String endereco;
	@NotNull
	private String email;
	@NotNull
	private String telefone;
	@NotNull
	private String key;
	
	
	public UserDTO() {
		
	}
	
	

	public UserDTO(long id, String nome, String cpf, String endereco, String email,String telefone) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
	}



	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public String getKey() {
		return key;
	}



	public void setKey(String key) {
		this.key = key;
	}
	
	
	
}
