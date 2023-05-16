package com.shoppingapplication.productapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shoppingapplication.productapi.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query(value = "select p from Product p join Category c on p.category.id = c.id where c.id = :categoryId")
	public List<Product> getProductByCategory(@Param("categoryId") long categoryId);
	
	@Query(value = "select p from Product p where p.identifier = :productIdentifier")
	public Product findByProductIdentifier(@Param("productIdentifier")String productIdentifier);
}
