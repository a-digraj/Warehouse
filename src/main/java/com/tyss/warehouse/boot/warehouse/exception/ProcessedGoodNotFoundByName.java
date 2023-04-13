package com.tyss.warehouse.boot.warehouse.exception;

public class ProcessedGoodNotFoundByName extends RuntimeException{
	private String message;

	public ProcessedGoodNotFoundByName(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
