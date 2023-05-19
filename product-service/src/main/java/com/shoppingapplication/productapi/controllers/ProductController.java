package com.shoppingapplication.productapi.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingapplication.productapi.dtos.ProductDTO;
import com.shoppingapplication.productapi.services.ProductService;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping()
	public List<ProductDTO> listAll(){
		return service.list();
	}
	@GetMapping("/category/{categoryId}")
	public List<ProductDTO> getProductByCategory(@PathVariable Long categoryId){
		return service.productsByCategory(categoryId);
	}
	@GetMapping("/{productIdentifier}")
	public ResponseEntity<?> findByIdentifier(@PathVariable String productIdentifier){
		ProductDTO dto = service.searchIdentifier(productIdentifier);
		if(dto!=null) return new ResponseEntity<>(dto, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping()
	public ResponseEntity<?> newProduct(@Valid @RequestBody ProductDTO productDTO)throws ConstraintViolationException{
		ProductDTO newProduct = service.saveProduct(productDTO);
		if(newProduct==null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(newProduct, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteByid(@PathVariable Long id) {
		if(service.deleteById(id)!=null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
			
	
}
