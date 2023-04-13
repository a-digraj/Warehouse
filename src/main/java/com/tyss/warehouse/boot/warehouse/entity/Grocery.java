package com.tyss.warehouse.boot.warehouse.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;

@Entity
public class Grocery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gId;
	@NotNull(message = "grocery name cannot be null")
	@NotBlank(message = "grocery name cannot be empty")
	private String groceryName;
	@NotNull(message = "grocery name cannot be null")
	@NotBlank(message = "grocery best before must be provided")
	private String gcoceryBestBefore;
	@Positive(message = "Value must be positive")
	private double groceryPrice;
	@Positive(message = "Value must be positive")
	private int quantity;
	public int getgId() {
		return gId;
	}
	public void setgId(int gId) {
		this.gId = gId;
	}
	public String getGroceryName() {
		return groceryName;
	}
	public void setGroceryName(String groceryName) {
		this.groceryName = groceryName;
	}
	public String getGcoceryBestBefore() {
		return gcoceryBestBefore;
	}
	public void setGcoceryBestBefore(String gcoceryBestBefore) {
		this.gcoceryBestBefore = gcoceryBestBefore;
	}
	public double getGroceryPrice() {
		return groceryPrice;
	}
	public void setGroceryPrice(double groceryPrice) {
		this.groceryPrice = groceryPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
