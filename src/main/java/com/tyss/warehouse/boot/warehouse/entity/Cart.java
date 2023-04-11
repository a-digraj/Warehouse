package com.tyss.warehouse.boot.warehouse.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ProcessedGood> processedgoods;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Grocery> groceries;
	private double cartCost;
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	public List<ProcessedGood> getProcessedgoods() {
		return processedgoods;
	}
	public void setProcessedgoods(List<ProcessedGood> processedgoods) {
		this.processedgoods = processedgoods;
	}
	public List<Grocery> getGroceries() {
		return groceries;
	}
	public void setGroceries(List<Grocery> groceries) {
		this.groceries = groceries;
	}
	public double getCartCost() {
		return cartCost;
	}
	public void setCartCost(double cartCost) {
		this.cartCost = cartCost;
	}
	
	
}
