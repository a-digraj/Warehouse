package com.tyss.warehouse.boot.warehouse.exception;

public class UserIdnotFoundException extends RuntimeException {
	
	private String message;

	public UserIdnotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
	
	
}
