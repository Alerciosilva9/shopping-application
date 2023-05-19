package com.shoppingapplication.userapi.services;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.client.exception.UserNotFoundException;
import com.shoppingapplication.userapi.dtos.UserDto;
import com.shoppingapplication.userapi.entities.User;
import com.shoppingapplication.userapi.repositories.UserRepository;

@Service
public class UserService {

	
	@Autowired
	UserRepository repository;
	
	public List<UserDto> usersList() {
		List<User> result =  repository.findAll();
		return result.stream().map(UserDto::new).toList();
	}
	
	public UserDto findById(Long Id) {
		User user = repository.findById(Id).orElse(null);
		if(user!=null){
			return new UserDto(user);
		}
		return null;
	}
	
	
	
	public boolean deleteById(Long Id) {
		User user = repository.findById(Id).orElse(null);
		if(user!=null){
			repository.deleteById(Id);
			return true;
		}
		return false;
	}
	
	
	
	
	public UserDto saveUser(UserDto dto) {
		User usertosave = new User(dto);
		UserDto usersave = new UserDto(repository.save(usertosave));
		return usersave;
	}
	
	public UserDto findByCpf(String cpf){
		User user = repository.findByCpf(cpf);
		if (user != null){
			return new UserDto(user);
		}
		throw new UserNotFoundException();
	}
	
	public List<UserDto> queryByName(String name){
		List<User> usuarios = repository.queryByNomeLike(name);
		return usuarios.stream().map(UserDto::new).toList();
	}
	
	
	//findById, save, delete, findByCpf e queryByName
}
