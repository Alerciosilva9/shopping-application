package com.shopping.client.dto;

import java.util.Date;
import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class ShopDTO{
	@NotBlank
	private String userIdentifier;
	@NotNull 
	private float total;
	@NotNull
	private Date date;
	@NotNull
	private List<ItemDTO> items;
	
	
	
	public ShopDTO(String userIdentifier,float total,Date date,List<ItemDTO> items) {
		this.userIdentifier = userIdentifier;
		this.total = total;
		this.date = date;
		this.items = items;
	}

	public ShopDTO() {
			this.date = new Date();
	}
			
	public String getUserIdentifier() {
		return userIdentifier;
	}
	public float getTotal() {
		return total;
	}
	public Date getDate() {
		return date;
	}
	public List<ItemDTO> getItems() {
		return items;
	}
	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier = userIdentifier;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}
	
	

}
