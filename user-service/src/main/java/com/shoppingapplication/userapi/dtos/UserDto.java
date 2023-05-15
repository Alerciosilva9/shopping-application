package com.shoppingapplication.userapi.dtos;

import java.util.Date;
import org.springframework.beans.BeanUtils;
import com.shoppingapplication.userapi.entities.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public class UserDto {

	
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
	
	
	public UserDto() {
		
	}
	
	public UserDto(User entity) {
		this.nome = entity.getNome();
		this.telefone = entity.getTelefone();
		this.cpf = entity.getCpf();
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
	
}
