package com.shoppingapplication.shoppingapi.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shoppingapplication.shoppingapi.dtos.ShopReportDTO;
import com.shoppingapplication.shoppingapi.entities.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long>{
	
	public List<Shop> findAllByUserIdentifier(String userIdentifier);
	
	public List<Shop> findAllByTotalGreaterThan(Float total);
	
	@Query(value = "select s from Shop s where s.date >= :shopDate ")
	List<Shop> findAllByDateGreaterThanEquals(Date shopDate);
	
	
	@Query(value= "select count(sp.id), sum(sp.total), avg(sp.total) from Shop sp where date >= :dataInicio and date <= :dataFim ")
	List<String[]> getReportByDate(Date dataInicio, Date dataFim);
	
	/*
	 * 
	 * sb.append("select count(sp.id), sum(sp.total), avg(sp.total)");
		sb.append("from shopping.shop sp ");
		sb.append("where sp.date >= :dataInicio ");
		sb.append("and sp.date <= :dataFim ");
		
		
			sb.append("select s ");
		sb.append("from Shop s ");
		sb.append("where s.date >= :dataInicio ");
		
		if (dataFim != null){
			sb.append("and s.date <= :dataFim ");
		}
		if (valorMinimo != null){
			sb.append("and s.total <= :valorMinimo ");
		}
	 */


}
