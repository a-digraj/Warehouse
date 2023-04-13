package com.tyss.warehouse.boot.warehouse.exception;

public class AdminCredentialsNotValid extends RuntimeException{
	
	private String message;

	public AdminCredentialsNotValid(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	
	
}
