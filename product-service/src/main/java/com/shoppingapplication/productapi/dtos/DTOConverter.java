package com.shoppingapplication.productapi.dtos;
import com.shopping.client.dto.CategoryDTO;
import com.shopping.client.dto.ProductDTO;
import com.shoppingapplication.productapi.entities.Category;
import com.shoppingapplication.productapi.entities.Product;


public class DTOConverter{
	public static CategoryDTO convert(Category category){
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setNome(category.getNome());return
		categoryDTO;
	}
	
	public static ProductDTO convert(Product product){
		ProductDTO productDTO = new ProductDTO();
		productDTO.setNome(product.getNome());
		productDTO.setPreco(product.getPreco());
		if (product.getCategory() != null){
			productDTO.setCategory(
			DTOConverter.convert(product.getCategory()));
		}
		return productDTO;
	}
}