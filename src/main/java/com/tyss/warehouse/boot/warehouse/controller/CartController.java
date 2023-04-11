package com.tyss.warehouse.boot.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.warehouse.boot.warehouse.config.ResponseStructure;
import com.tyss.warehouse.boot.warehouse.entity.Cart;
import com.tyss.warehouse.boot.warehouse.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService service;
	@PostMapping
	public ResponseEntity<ResponseStructure<Cart>> saveCart(@RequestBody Cart cart){
		return service.saveCart(cart);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Cart>> updateCart(@RequestBody Cart cart,@RequestParam int id){
		return service.updateCart(cart,id);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Cart>> findCart(@RequestParam int id){
		return service.findCart(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Cart>> deleteCart(@RequestParam int id){
		return service.deleteCart(id);
	}
	
}
