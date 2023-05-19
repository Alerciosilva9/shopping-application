package com.shoppingapplication.productapi.entities;

import com.shoppingapplication.productapi.dtos.ProductDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@NotNull
	@Column(name = "product_identifier")
	private String identifier;
	private String nome;
	private String descricao;
	//private float category_id;
	private float preco;
	
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	
	public Integer getId() {
		return id;
	}
	public String getIdentifier() {
		return identifier;
	}
	public String getNome() {
		return nome;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Product(ProductDTO entity){
		this.nome = entity.getNome();
		this.identifier = entity.getProductIdentifier();
		this.preco = entity.getPreco();
		this.descricao = entity.getDescricao();
		if(entity.getCategory()!=null) {
			this.category = new Category(entity.getCategory());
		}
	}
	
	public Product() {
		
	}
	
	
	
	
	
}
