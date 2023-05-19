package com.shoppingapplication.shoppingapi.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.shopping.client.dto.ProductDTO;
import com.shopping.client.exception.ProductNotFoundException;
import com.shopping.client.exception.UserNotFoundException;

@Service
public class ProductService {

	public ProductDTO getProductByIdentifier(String productIdentifier) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = "http://localhost:8081/products/" + productIdentifier;
			System.out.println("request to " + url);
			ResponseEntity<ProductDTO> response = restTemplate.getForEntity(url, ProductDTO.class);
			return response.getBody();
		} catch (HttpClientErrorException.NotFound e) {
			throw new ProductNotFoundException();
		}
	}
}
