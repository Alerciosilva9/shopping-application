package com.shoppingapplication.shoppingapi.exception.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shopping.client.dto.ErrorDTO;
import com.shopping.client.exception.ProductNotFoundException;
import com.shopping.client.exception.UserNotFoundException;

import java.util.Date;

import org.springframework.http.HttpStatus;

@RestControllerAdvice(basePackages ="com.shoppingapplication.shoppingapi.controller") 
public class ShoppingAdviceController{
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProductNotFoundException.class)
	public ErrorDTO handleUserNotFound(ProductNotFoundException userNotFoundException){
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
		errorDTO.setMessage("Produto não encontrado.");
		errorDTO.setTimestamp(new Date());
		return errorDTO;
	}
	
	@ResponseBody@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public ErrorDTO handleUserNotFound(UserNotFoundException userNotFoundException){
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
		errorDTO.setMessage("Usuário não encontrado.");
		errorDTO.setTimestamp(new Date());return
		errorDTO;
	}
}
