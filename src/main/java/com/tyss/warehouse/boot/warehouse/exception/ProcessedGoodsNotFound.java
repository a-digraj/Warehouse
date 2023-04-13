package com.tyss.warehouse.boot.warehouse.exception;

public class ProcessedGoodsNotFound extends RuntimeException{
	
	private String message;

	public String getMessage() {
		return message;
	}

	public ProcessedGoodsNotFound(String message) {
		this.message = message;
	}
	
	
}
