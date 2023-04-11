package com.tyss.warehouse.boot.warehouse.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.warehouse.boot.warehouse.entity.Cart;
import com.tyss.warehouse.boot.warehouse.repo.CartRepo;
@Repository
public class CartDao {
	@Autowired
	private CartRepo repo;
	
	public Cart addCart(Cart cart) {
		return repo.save(cart);
	}
	public Cart updateCart(Cart cart, int id) {
		  Optional<Cart> cart2 = repo.findById(id);
		  if(cart2.isPresent()) {
			  cart.setCartId(id);
			  return repo.save(cart);
		  }
		  return null;
	}
	public Cart findCartById(int id) {
		Optional<Cart> cart2 = repo.findById(id);
		if(cart2.isPresent()) {
			return cart2.get();
		}
		return null;
	}
	public Cart deleteCartById(int id) {
		Optional<Cart> cart2 = repo.findById(id);
		if(cart2.isPresent()) {
			repo.delete(cart2.get());
			return cart2.get();
		}
		return null;
	}
}