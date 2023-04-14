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
	@ApiOperation(value = "add grocery to cart", notes = "API is used to add grocery to existing cart")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully added"),
			@ApiResponse(code = 400, message = "Id not found for the given cart ID or grocery id") })
	@PutMapping("/addgrocery")
	public ResponseEntity<ResponseStructure<Cart>> addGroceryToCart(@RequestParam int cartid,@RequestParam int groceryid,@RequestParam int groceryquant){
		return service.addGroceryToCart(cartid, groceryid,groceryquant);
	}
	@ApiOperation(value = "add processed good to cart", notes = "API is used to add processed good to existing cart")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully added"),
			@ApiResponse(code = 400, message = "Id not found for the given cart ID or processed product id") })
	@PutMapping("/addprogoods")
	public ResponseEntity<ResponseStructure<Cart>> addProcessedGoodsToCart(@RequestParam int cartid,@RequestParam int processedgoodid){
		return service.addProcesseddGoodToCart(cartid, processedgoodid);
	}
	@ApiOperation(value = "delete grocery from cart", notes = "API is used to delete grocery from existing cart")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully removed"),
			@ApiResponse(code = 400, message = "Id not found for the given cart ID or grocery id") })
	@DeleteMapping("/deletegrocery")
	public ResponseEntity<ResponseStructure<Cart>> deleteGroceryByName(@RequestParam int cartid,@Valid @RequestParam String groceryname){
		return service.deleteGroceryByName(cartid, groceryname);
	}
	@ApiOperation(value = "delete processed good from cart", notes = "API is used to delete processed good from existing cart")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully removed"),
			@ApiResponse(code = 400, message = "Id not found for the given cart ID or processed product id") })
	@DeleteMapping("/deletepgood")
	public ResponseEntity<ResponseStructure<Cart>> deleteProcessedGoodByName(@RequestParam int cartid,@Valid @RequestParam String pgoodname){
		return service.deleteProcessedGoodByName(cartid, pgoodname);
	}
}
