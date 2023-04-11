package com.tyss.warehouse.boot.warehouse.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
public class Warehouse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int warehouseId;
	private String warehouseAddress;
	private long warehouseNumber;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ProcessedGood> processedGoods;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Grocery> groceries;
	@OneToOne
	@NotNull(message = "warehouse must have an admin")
	@NotEmpty(message = "admin for warehouse cannot be empty")
	private Admin admin;
	public int getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}
	public String getWarehouseAddress() {
		return warehouseAddress;
	}
	public void setWarehouseAddress(String warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}
	public long getWarehouseNumber() {
		return warehouseNumber;
	}
	public void setWarehouseNumber(long warehouseNumber) {
		this.warehouseNumber = warehouseNumber;
	}
	public List<ProcessedGood> getProcessedGoods() {
		return processedGoods;
	}
	public void setProcessedGoods(List<ProcessedGood> processedGoods) {
		this.processedGoods = processedGoods;
	}
	public List<Grocery> getGroceries() {
		return groceries;
	}
	public void setGroceries(List<Grocery> groceries) {
		this.groceries = groceries;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
}
