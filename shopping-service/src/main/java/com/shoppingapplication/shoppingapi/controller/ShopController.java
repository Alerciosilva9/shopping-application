package com.shoppingapplication.shoppingapi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingapplication.shoppingapi.dtos.ShopDTO;
import com.shoppingapplication.shoppingapi.dtos.ShopReportDTO;
import com.shoppingapplication.shoppingapi.services.ShopService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/shopping")
public class ShopController {
	
	@Autowired
	ShopService service;
	
	@GetMapping()
	public List<ShopDTO> findAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public ShopDTO findById(@PathVariable Long id){
		return service.findById(id);
	}
	
	
	@GetMapping("shopByUser/{identifier}")
	public List<ShopDTO> getByidentifier(@PathVariable String identifier){
		return service.getByUser(identifier);
	}
	
	@PostMapping
	public ShopDTO save(@Valid @RequestBody ShopDTO dto) {
		return service.save(dto);
	}
	
	@GetMapping("/shopping/shopByDate")
	public List<ShopDTO> getByDate(@RequestBody ShopDTO shopDTO){
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
