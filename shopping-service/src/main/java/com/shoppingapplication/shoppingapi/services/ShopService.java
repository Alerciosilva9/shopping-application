package com.shoppingapplication.shoppingapi.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.shopping.client.dto.ItemDTO;
import com.shopping.client.dto.ProductDTO;
import com.shoppingapplication.shoppingapi.dtos.DTOConverter;
import com.shoppingapplication.shoppingapi.dtos.ShopDTO;
import com.shoppingapplication.shoppingapi.dtos.ShopReportDTO;
import com.shoppingapplication.shoppingapi.entities.Shop;
import com.shoppingapplication.shoppingapi.repositories.ShopRepository;

@Service
public class ShopService {
	@Autowired
	ShopRepository repository;

	@Autowired
	UserService userService;
	@Autowired
	ProductService productService;
	
	
	public List<ShopDTO> getAll(){
		List<Shop> result = repository.findAll();
		return result.stream().map(ShopDTO::new).toList();
		
	}
	
	public List<ShopDTO> getByUser(String userIdentifier){
		List<Shop> result = repository.findAllByUserIdentifier(userIdentifier);
		return result.stream().map(ShopDTO::new).toList();
	}
	
	public com.shopping.client.dto.ShopDTO save(com.shopping.client.dto.ShopDTO shopDTO){
		if(userService.getUserByCpf(shopDTO.getUserIdentifier())!=null) {
			if(!validateProducts(shopDTO.getItems())) {
				return null;
			}
			
			Shop shop = new Shop(shopDTO);
			float total = shopDTO.getItems().stream().map(x -> x.getPrice()).reduce((float) 0,Float::sum);
			System.out.println("TTOOTAL "+total);
			shop.setTotal(total);	
			shop.setDate(new Date());
			shop = repository.save(shop);	
			return DTOConverter.convert(shop);
		}else {
			return null;
		}
	}
	
	private boolean validateProducts(List<ItemDTO> items){
		for(ItemDTO dto:items) {
			ProductDTO productDTO = productService.getProductByIdentifier(dto.getProductIdentifier());
			if(productDTO==null) {
				return false;
			}
			dto.setPrice(productDTO.getPreco());
		}
		return true;
		
		
		
		
	}
	
	public ShopDTO findById(@PathVariable Long id){
		Shop shop = repository.findById(id).orElse(null);
		if(shop!=null) {
			return new ShopDTO(shop);
		}
		return null;
	}
	
	public List<ShopDTO> getByDate(ShopDTO shopDTO){
		List<Shop> shops = repository.findAllByDateGreaterThanEquals(shopDTO.getDate());
				
		return shops.stream().map(ShopDTO::new).toList();
	}
	
//	public List<ShopDTO> getShopsByFilter(Date dataInicio, Date dataFim,Float valorMinimo){
//		List<Shop> shops = reportRepository.getShopByFilters(dataInicio, dataFim, valorMinimo);
//		return shops.stream().map(ShopDTO::new).toList();
//	}
//	
	public ShopReportDTO getReportByDate(Date dataInicio,Date dataFim){
		
		List<String[]> results =  repository.getReportByDate(dataInicio, dataFim);
		
		ShopReportDTO dto = new ShopReportDTO();

		for (String[] result : results) {
		    if(result[0]!=null && result[1]!=null && result[2]!=null) {
		    	dto.setCount(Integer.valueOf(result[0]));  
				dto.setMean(Double.valueOf(result[2]));
				dto.setTotal(Double.valueOf(result[1])); 
		    }
			     
		}
		return dto;
	}
	
	
	
}
