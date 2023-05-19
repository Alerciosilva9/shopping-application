package com.shoppingapplication.userapi.dtos;
import com.shopping.client.dto.UserDTO;
import com.shoppingapplication.userapi.entities.User;

public class DTOConverter{
	public static UserDTO convert(User user){
		UserDTO userDTO =new UserDTO();
		userDTO.setNome(user.getNome());
		userDTO.setEndereco(user.getEndereco());
		userDTO.setCpf(user.getCpf());
		userDTO.setKey(user.getKey());
		return userDTO;
	}
}
