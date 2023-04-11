package com.tyss.warehouse.boot.warehouse.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Grocery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gId;
	@NotEmpty(message = "processed good name cannot be empty")
	private String gName;
	@NotNull(message = "best before must be provided")
	private String gBestBefore;
	@Positive(message = "Value must be positive")
	private double price;
	@Positive(message = "Value must be positive")
	private int quantity;
	public int getgId() {
		return gId;
	}
	public void setgId(int gId) {
		this.gId = gId;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public String getgBestBefore() {
		return gBestBefore;
	}
	public void setgBestBefore(String gBestBefore) {
		this.gBestBefore = gBestBefore;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
