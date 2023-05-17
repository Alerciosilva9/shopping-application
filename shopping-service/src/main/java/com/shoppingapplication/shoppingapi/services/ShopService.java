package com.shoppingapplication.shoppingapi.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.shoppingapplication.shoppingapi.dtos.ShopDTO;
import com.shoppingapplication.shoppingapi.dtos.ShopReportDTO;
import com.shoppingapplication.shoppingapi.entities.Shop;
import com.shoppingapplication.shoppingapi.repositories.ShopRepository;

@Service
public class ShopService {
	@Autowired
	ShopRepository repository;

	
	
	
	public List<ShopDTO> getAll(){
		List<Shop> result = repository.findAll();
		return result.stream().map(ShopDTO::new).toList();
		
	}
	
	public List<ShopDTO> getByUser(String userIdentifier){
		List<Shop> result = repository.findAllByUserIdentifier(userIdentifier);
		return result.stream().map(ShopDTO::new).toList();
	}
	
	public ShopDTO save(ShopDTO shopDTO){
		float total = shopDTO.getItems().stream().map(x -> x.getPrice()).reduce((float) 0,Float::sum);
		shopDTO.setTotal(total);
		
		Shop shop = new Shop(shopDTO);
		shop.setDate(new Date());
		shop = repository.save(shop);
		return new ShopDTO(shop);
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
