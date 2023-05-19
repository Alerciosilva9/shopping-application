package com.shoppingapplication.productapi.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shopping.client.dto.ErrorDTO;
import com.shopping.client.exception.CategoryNotFoundException;
import com.shopping.client.exception.IdentifierAlreadyExists;
import com.shopping.client.exception.ProductNotFoundException;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@RestControllerAdvice(basePackages = "com.shoppingapplication.productapi.controllers") 
public class ProductControllerAdvice{
	
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
	
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler
	(CategoryNotFoundException.class)
	public ErrorDTO handleCategoryNotFound(CategoryNotFoundException categoryNotFoundException){
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setStatus(HttpStatus.NOT_FOUND.value());
		errorDTO.setMessage("Categoria não encontrada.");
		errorDTO.setTimestamp(new Date());
		return errorDTO;
	}
	
	@ResponseBody @ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class) 
	public ErrorDTO processValidationError(MethodArgumentNotValidException ex){
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setStatus(HttpStatus.BAD_REQUEST.value());
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		StringBuilder sb = new StringBuilder("Valor inválido para o(s) campo(s):");
		for (FieldError fieldError : fieldErrors) {
			sb.append(", ");
			sb.append(fieldError.getField());
		}
		errorDTO.setMessage(sb.toString());
		errorDTO.setTimestamp(
		new Date());
		return errorDTO;
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IdentifierAlreadyExists.class)
	public ErrorDTO handleIdentifierAlreadyExists(IdentifierAlreadyExists identifierAlreadyExists){
		ErrorDTO errorDTO = new ErrorDTO();
		errorDTO.setStatus(HttpStatus.BAD_REQUEST.value());
		errorDTO.setMessage("Identificador de Produto ja existe.");
		errorDTO.setTimestamp(new Date());
		return errorDTO;
	}
}