package com.shoppingapplication.productapi.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.shopping.client.exception.CategoryNotFoundException;
import com.shopping.client.exception.IdentifierAlreadyExists;
import com.shopping.client.exception.ProductNotFoundException;
import com.shoppingapplication.productapi.dtos.ProductDTO;
import com.shoppingapplication.productapi.entities.Product;
import com.shoppingapplication.productapi.repositories.CategoryRepository;
import com.shoppingapplication.productapi.repositories.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	@Autowired
	CategoryRepository categoryRepository;
	

	public List<ProductDTO> list(){
		List<Product> result = repository.findAll();
		
		return result.stream().map(ProductDTO::new).toList();
	}
	
	public ProductDTO searchIdentifier(String Identifier) {
		Product result  = repository.findByProductIdentifier(Identifier);
		if(result!=null) return new ProductDTO(result);
		throw new ProductNotFoundException();
	}
	
	public List<ProductDTO> productsByCategory(Long category){
		List<Product> result = repository.getProductByCategory(category);
		return result.stream().map(ProductDTO::new).toList();
	}
	
	public ProductDTO saveProduct(ProductDTO dto){
		Boolean existsCategory = categoryRepository.existsById(dto.getCategory().getId());
		
		if(!existsCategory) {
			System.out.println(dto.getCategory().getId());
			throw new CategoryNotFoundException();
		}
		if(repository.findByProductIdentifier(dto.getProductIdentifier())!=null) throw new IdentifierAlreadyExists();
		Product product = repository.save(new Product(dto));
		return new ProductDTO(product);
		
	}
	
	public ProductDTO deleteById(Long Id) {
		Product result = repository.findById(Id).orElse(null);
		if(result!=null){
			return new ProductDTO(result);
		}
		throw new ProductNotFoundException();
	}
	
	
}
