package com.tyss.warehouse.boot.warehouse.dto;

import org.springframework.stereotype.Component;

import com.tyss.warehouse.boot.warehouse.entity.Cart;
@Component
public class UserDto {
	private int userId;
	private String userName;
	private Cart cart;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	
}
