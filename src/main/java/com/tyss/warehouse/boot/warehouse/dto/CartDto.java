package com.tyss.warehouse.boot.warehouse.dto;

import org.springframework.stereotype.Component;

import com.tyss.warehouse.boot.warehouse.entity.User;
@Component
public class CartDto {
	private int cartId;
	private User user;
	private double cartCost;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getCartCost() {
		return cartCost;
	}
	public void setCartCost(double cartCost) {
		this.cartCost = cartCost;
	}
	
	
}
