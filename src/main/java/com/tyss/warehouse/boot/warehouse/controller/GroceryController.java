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
import com.tyss.warehouse.boot.warehouse.entity.Grocery;
import com.tyss.warehouse.boot.warehouse.service.GroceryService;

@RestController
@RequestMapping("/grocery")
public class GroceryController {
	@Autowired
	private GroceryService service;
	@PostMapping
	public ResponseEntity<ResponseStructure<Grocery>> saveGrocery(@RequestBody Grocery grocery){
		return service.saveGrocery(grocery);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Grocery>> updateGrocery(@RequestBody Grocery grocery, @RequestParam int id){
		return service.saveGrocery(grocery);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Grocery>> findGrocery(@RequestParam int id){
		return service.findGrocery(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Grocery>> deleteGrocery(@RequestParam int id){
		return service.deleteGrocery(id);
	}
	
	
}
