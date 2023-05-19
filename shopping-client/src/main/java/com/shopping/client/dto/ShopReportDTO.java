package com.shopping.client.dto;




public class ShopReportDTO {
	private Integer count;
	private Double total;
	private Double mean;
	
	public ShopReportDTO(Integer count, Double total, Double mean) {
		this.count = count;
		this.total = total;
		this.mean = mean;
	}
	
	public ShopReportDTO() {
		
	}

	public Integer getCount() {
		return count;
	}

	public Double getTotal() {
		return total;
	}

	public Double getMean() {
		return mean;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public void setMean(Double mean) {
		this.mean = mean;
	}
	
	
	
}
