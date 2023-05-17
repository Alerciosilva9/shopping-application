package com.shoppingapplication.shoppingapi.entities;

import com.shoppingapplication.shoppingapi.dtos.ItemDTO;

import jakarta.persistence.Embeddable;

@Embeddable 
public class Item{

	private String productIdentifier;
	private float price;
	
	public Item() {
		
	}
	
	public Item(ItemDTO dto) {
		this.productIdentifier = dto.getProductIdentifier();
		this.price = dto.getPrice();
	}
	
	public String getProductIdentifier() {
		return productIdentifier;
	}
	public float getPrice() {
		return price;
	}
	public void setProductIdentifier(String productIdentifier) {
		this.productIdentifier = productIdentifier;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
// gets and sets
}