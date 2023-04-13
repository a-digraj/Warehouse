package com.tyss.warehouse.boot.warehouse.exception;

public class WarehouseAlreadyExistException extends RuntimeException {
	private String message;

	public WarehouseAlreadyExistException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
