package com.shoppingapplication.shoppingapi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.shopping.client.dto.ProductDTO;
import com.shopping.client.dto.UserDTO;
import com.shopping.client.dto.ShopDTO;
import com.shoppingapplication.shoppingapi.dtos.ShopReportDTO;
import com.shoppingapplication.shoppingapi.services.ProductService;
import com.shoppingapplication.shoppingapi.services.ShopService;
import com.shoppingapplication.shoppingapi.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/shopping")
public class ShopController {
	
	@Autowired
	ShopService service;
	
	@Autowired 
	UserService userService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping()
	public List<com.shoppingapplication.shoppingapi.dtos.ShopDTO> findAll(){
		return service.getAll();
	}	
	@GetMapping("/{id}")
	public com.shoppingapplication.shoppingapi.dtos.ShopDTO findById(@PathVariable Long id){
		return service.findById(id);
	}
	
	
	@GetMapping("shopByUser/{identifier}")
	public List<com.shoppingapplication.shoppingapi.dtos.ShopDTO> getByidentifier(@PathVariable String identifier){
		return service.getByUser(identifier);
	}
	
	@PostMapping
	public ShopDTO save(@Valid @RequestBody ShopDTO dto,@RequestHeader(name ="key", required=true) String key) {
		System.out.println("KEY--"+key);
		return service.save(dto,key);
	}
	
	@GetMapping("/shopping/shopByDate")
	public List<com.shoppingapplication.shoppingapi.dtos.ShopDTO> getByDate(@RequestBody com.shoppingapplication.shoppingapi.dtos.ShopDTO shopDTO){
		return service.getByDate(shopDTO);

	}
	
//	@GetMapping("/search") 
//	public List<ShopDTO> getShopsByFilter(@RequestParam(name ="dataInicio", required=true)
//	@DateTimeFormat(pattern = "dd/MM/yyyy") Date dataInicio,@RequestParam(name = "dataFim", required=false)
//	@DateTimeFormat(pattern = "dd/MM/yyyy")Date dataFim, @RequestParam(name = "valorMinimo", required=false)Float valorMinimo){
//		return service.getShopsByFilter(dataInicio, dataFim, valorMinimo);
//	}
	
	
	@GetMapping("/report") 
	public ShopReportDTO getReportByDate(@RequestParam(name ="dataInicio", required=true)@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date dataInicio,@RequestParam(name = "dataFim", required=true)@DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFim){
		return service.getReportByDate(dataInicio, dataFim);
	}
	
}
