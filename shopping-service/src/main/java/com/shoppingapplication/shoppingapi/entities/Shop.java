package com.shoppingapplication.shoppingapi.entities;

import java.util.Date;
import java.util.List;

import com.shopping.client.dto.ShopDTO;
import com.shopping.client.dto.ItemDTO;


import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
public class Shop{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String userIdentifier;
	private float total;
	private Date date;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "item", joinColumns = @JoinColumn(name = "shop_id"))
	private	List<Item> items;
	// gets e setspublic static Shop convert(ShopDTO shopDTO)
	public Shop() {
		
	}
	
	public Shop(ShopDTO dto) {
		this.userIdentifier = dto.getUserIdentifier();
		this.total = dto.getTotal();
		this.date = dto.getDate();
		this.items = dto.getItems().stream().map(Item::new).toList();
	}
	
	public long getId() {
		return id;
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
	public List<Item> getItems() {
		return items;
	}
	public void setId(long id) {
		this.id = id;
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
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
}