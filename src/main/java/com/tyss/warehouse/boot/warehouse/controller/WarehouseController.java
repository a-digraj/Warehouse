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
import com.tyss.warehouse.boot.warehouse.entity.Warehouse;
import com.tyss.warehouse.boot.warehouse.service.WarehouseService;
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
	@Autowired
	private WarehouseService service;
	@PostMapping
	public ResponseEntity<ResponseStructure<Warehouse>> saveWarehouse(@RequestBody Warehouse warehouse){
		return service.saveWarehouse(warehouse);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Warehouse>> updateWarehouse(@RequestBody Warehouse warehouse, @RequestParam int id){
		return service.updateWarehouse(warehouse, id);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Warehouse>> getWarehouse(@RequestParam int id){
		return service.findWarehouse(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Warehouse>> deleteWarehouse(@RequestParam int id){
		return service.deleteWarehouse(id);
	}
	
	
	
}
