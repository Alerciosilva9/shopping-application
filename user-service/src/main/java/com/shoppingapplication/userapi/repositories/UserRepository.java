package com.shoppingapplication.userapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingapplication.userapi.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByCpfAndKey(String cpf, String Key);
	
	List<User> queryByNomeLike(String name);
}
