package com.tyss.warehouse.boot.warehouse.exception;

public class AdminAlreadyExistsException extends RuntimeException{
	
	private String message;

	public AdminAlreadyExistsException(String message) {
		this.message = message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
