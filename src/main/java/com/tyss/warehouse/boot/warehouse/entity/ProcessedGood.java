package com.tyss.warehouse.boot.warehouse.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class ProcessedGood {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pgoodId;
	@NotNull(message = "name of goods cannot be null or empty")
	@NotEmpty(message = "name of goods cannot be null or empty")
	private String pgoodName;
	@NotEmpty(message = "manufactured date cannot be empty")
	private String  pgoodmfgDate;
	@NotEmpty(message = "expiry date cannot be empty")
	private String pgoodexpDate;
	@Positive(message = "Value must be positive")
	private double price;
	@Positive(message = "Value must be positive")
	private int pgoodQuantity;
	public int getPgoodId() {
		return pgoodId;
	}
	public void setPgoodId(int pgoodId) {
		this.pgoodId = pgoodId;
	}
	public String getPgoodName() {
		return pgoodName;
	}
	public void setPgoodName(String pgoodName) {
		this.pgoodName = pgoodName;
	}
	
	public String getPgoodmfgDate() {
		return pgoodmfgDate;
	}
	public void setPgoodmfgDate(String pgoodmfgDate) {
		this.pgoodmfgDate = pgoodmfgDate;
	}
	public String getPgoodexpDate() {
		return pgoodexpDate;
	}
	public void setPgoodexpDate(String pgoodexpDate) {
		this.pgoodexpDate = pgoodexpDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPgoodQuantity() {
		return pgoodQuantity;
	}
	public void setPgoodQuantity(int pgoodQuantity) {
		this.pgoodQuantity = pgoodQuantity;
	}
	

	
	
}
