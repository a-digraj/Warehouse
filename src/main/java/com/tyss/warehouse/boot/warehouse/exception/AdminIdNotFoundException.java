package com.tyss.warehouse.boot.warehouse.exception;

public class AdminIdNotFoundException extends RuntimeException {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public AdminIdNotFoundException(String message) {
		this.message = message;
	}

}
