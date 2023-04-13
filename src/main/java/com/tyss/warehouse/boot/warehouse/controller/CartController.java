package com.tyss.warehouse.boot.warehouse.controller;

import javax.validation.Valid;

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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService service;
	@ApiOperation(value = "Save Cart", notes = "API is used to save Cart")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 400, message = "Id not found for the given cartID") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Cart>> saveCart(@Valid  @RequestBody Cart cart){
		return service.saveCart(cart);
	}
	@ApiOperation(value = "update cart", notes = "API is used to update cart")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 400, message = "Id not found for the given cart ID") })
	@PutMapping
	public ResponseEntity<ResponseStructure<Cart>> updateCart(@Valid @RequestBody Cart cart,@RequestParam int cartid){
		return service.updateCart(cart, cartid);
	}
	@ApiOperation(value = "find cart", notes = "API is used to find cart")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 400, message = "Id not found for the given cart ID") })
	@GetMapping
	public ResponseEntity<ResponseStructure<Cart>> findCart(@RequestParam int cartid){
		return service.findCart(cartid);
	}
	@ApiOperation(value = "delete cart", notes = "API is used to delete cart")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully deleted"),
			@ApiResponse(code = 400, message = "Id not found for the given cart ID") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Cart>> deleteCart(@RequestParam int cartid){
		return service.deleteCart(cartid);
	}
	@PutMapping("/addgrocery")
	public ResponseEntity<ResponseStructure<Cart>> addGroceryToCart(@RequestParam int cartid,@RequestParam int groceryid){
		return service.addGroceryToCart(cartid, groceryid);
	}
	@PutMapping("/addprogoods")
	public ResponseEntity<ResponseStructure<Cart>> addProcessedGoodsToCart(@RequestParam int cartid,@RequestParam int processedgoodid){
		return service.addProcesseddGoodToCart(cartid, processedgoodid);
	}
}
