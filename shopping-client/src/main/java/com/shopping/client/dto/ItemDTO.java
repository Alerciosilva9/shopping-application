package com.shopping.client.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ItemDTO{
	@NotBlank
	private String productIdentifier;
	@NotNull
	private Float price;
	
	
	public ItemDTO() {
		
	}
	
	
	
	
	
	public ItemDTO(String productIdentifier, Float price) {
		this.productIdentifier = productIdentifier;
		this.price = price;
	}





	public String getProductIdentifier() {
		return productIdentifier;
	}
	public Float getPrice() {
		return price;
	}
	public void setProductIdentifier(String productIdentifier) {
		this.productIdentifier = productIdentifier;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	
	
	
}
