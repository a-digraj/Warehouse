package com.tyss.warehouse.boot.warehouse.controller;

import java.util.List;

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
import com.tyss.warehouse.boot.warehouse.entity.User;
import com.tyss.warehouse.boot.warehouse.service.UserService;
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;
	@PostMapping
	public ResponseEntity<ResponseStructure<UserDto>> saveUser(@RequestBody User user){
		return service.saveUser(user);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<UserDto>> updateUser(@RequestBody User user, @RequestParam int id){
		return service.updateUser(user, id);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<UserDto>> findUser(@RequestParam int id){
		return service.findUser(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<UserDto>> deleteUser(@RequestParam int id){
		return service.deleteUser(id);
	}
	@GetMapping("/getall")
	public ResponseEntity<ResponseStructure<List<UserDto>>> getAllUser(){
		return service.findAllUsers();
	}
}
