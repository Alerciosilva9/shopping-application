package com.shoppingapplication.productapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingapplication.productapi.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
