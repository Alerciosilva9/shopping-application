package com.shoppingapplication.userapi.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingapplication.userapi.dtos.UserDto;
import com.shoppingapplication.userapi.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping
	public List<UserDto> allusers() {
		return service.usersList();
	}
	
	//findById, save, delete, findByCpf e queryByName
	@GetMapping("/{id}")
	public ResponseEntity<?> findByid(@PathVariable Long id) {
		UserDto userbyid = service.findById(id);
		if(userbyid!=null) return new ResponseEntity<>(userbyid, HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody @Valid UserDto dto){
		UserDto newDto = service.saveUser(dto);
		if(newDto != null) {
			return new ResponseEntity<>(newDto, HttpStatus.CREATED); 
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
	}
	
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<?> findByCpf(@PathVariable String cpf) {
		UserDto userbycpf = service.findByCpf(cpf);
		if(userbycpf!=null) return new ResponseEntity<>(userbycpf, HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteByid(@PathVariable Long id) {
		if(service.deleteById(id)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
}
