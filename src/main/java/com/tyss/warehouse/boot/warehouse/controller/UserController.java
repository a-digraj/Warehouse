package com.tyss.warehouse.boot.warehouse.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.warehouse.boot.warehouse.config.ResponseStructure;
import com.tyss.warehouse.boot.warehouse.dto.UserDto;
import com.tyss.warehouse.boot.warehouse.entity.Cart;
import com.tyss.warehouse.boot.warehouse.entity.User;
import com.tyss.warehouse.boot.warehouse.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;
	@ApiOperation(value = "Save user", notes = "API is used to save user")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 400, message = "Id not found for the given  user ID") })
	@PostMapping
	public ResponseEntity<ResponseStructure<UserDto>> saveUser(@Valid @RequestBody User user){
		return service.saveUser(user);
	}
	@ApiOperation(value = "update user", notes = "API is used to update user")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 400, message = "Id not found for the given  user ID") })
	@PutMapping
	public ResponseEntity<ResponseStructure<UserDto>> updateUser(@Valid @RequestBody User user, @RequestParam int userid){
		return service.updateUser(user, userid);
	}
	@ApiOperation(value = "find user", notes = "API is used to find user")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully found"),
			@ApiResponse(code = 400, message = "Id not found for the given  user ID") })
	@GetMapping
	public ResponseEntity<ResponseStructure<UserDto>> findUser(@RequestParam int userid){
		return service.findUser(userid);
	}
	@ApiOperation(value = "delete user", notes = "API is used to delete user")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully deleted"),
			@ApiResponse(code = 400, message = "Id not found for the given  user ID") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<UserDto>> deleteUser(@RequestParam int userid){
		return service.deleteUser(userid);
	}
	@ApiOperation(value = "get all user", notes = "API is used to get all users")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully found all"),
			@ApiResponse(code = 400, message = "users not found") })
	@GetMapping("/getall")
	public ResponseEntity<ResponseStructure<List<UserDto>>> getAllUser(){
		return service.findAllUsers();
	}
	@DeleteMapping("/deletecart")
	public ResponseEntity<ResponseStructure<Cart>> deleteCartFromUser(@RequestParam int userid){
		return service.deleteCartFromUser(userid);
	}
}
