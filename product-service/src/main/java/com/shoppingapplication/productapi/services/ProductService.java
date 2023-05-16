package com.shoppingapplication.productapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingapplication.productapi.dtos.ProductDTO;
import com.shoppingapplication.productapi.entities.Product;
import com.shoppingapplication.productapi.repositories.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	

	public List<ProductDTO> list(){
		List<Product> result = repository.findAll();
		
		return result.stream().map(ProductDTO::new).toList();
	}
	
	public ProductDTO searchIdentifier(String Identifier) {
		Product result  = repository.findByProductIdentifier(Identifier);
		if(result==null) return null;
		
		return new ProductDTO(result);
	}
	
	public List<ProductDTO> productsByCategory(Long category){
		List<Product> result = repository.getProductByCategory(category);
		return result.stream().map(ProductDTO::new).toList();
	}
	
	public ProductDTO saveProduct(ProductDTO dto) {
		Product tosave = new Product(dto);
		repository.save(tosave);
		return new ProductDTO(tosave);
	}
	
	public boolean deleteById(Long Id) {
		Product result = repository.findById(Id).orElse(null);
		if(result!=null){
			repository.deleteById(Id);
			return true;
		}
		return false;
	}
	
	
}
