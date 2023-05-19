package com.shoppingapplication.shoppingapi.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.shopping.client.dto.UserDTO;
import com.shopping.client.exception.UserNotFoundException;

import jakarta.transaction.SystemException;

@Service 
public class UserService{
	
	public UserDTO getUserByCpf(String cpf){
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = "http://localhost:8080/users/cpf/" + cpf;
			ResponseEntity<UserDTO> response = restTemplate.getForEntity(url, UserDTO.class);
			return response.getBody();
		}
		catch(HttpClientErrorException.NotFound e) {
			throw new UserNotFoundException();
		}
	}
}