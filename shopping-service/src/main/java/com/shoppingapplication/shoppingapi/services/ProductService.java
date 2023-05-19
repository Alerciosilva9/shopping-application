package com.shoppingapplication.shoppingapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; 
import org.springframework.stereotype.Service; 
import org.springframework.web.client.RestTemplate;
import com.shopping.client.dto.ProductDTO;

@Service 
public class ProductService{
	
	
	
	public ProductDTO getProductByIdentifier(String productIdentifier){
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "http://localhost:8081/products/" + productIdentifier;
		System.out.println("request to "+url);
		ResponseEntity<ProductDTO> response = restTemplate.getForEntity(url, ProductDTO.class);
		return response.getBody();
	}
}
