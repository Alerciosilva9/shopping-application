package com.shopping.client.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class ErrorDTO {
	private int status;
	private String message;
	private Date timestamp;
	
	public ErrorDTO() {
		
	}
	
	
	
	
	public ErrorDTO(int status, String message, Date timestamp) {
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}




	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
