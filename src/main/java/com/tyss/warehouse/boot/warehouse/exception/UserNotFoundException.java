package com.tyss.warehouse.boot.warehouse.exception;

public class UserNotFoundException extends RuntimeException{
	private String message;

	public UserNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	
	
}
