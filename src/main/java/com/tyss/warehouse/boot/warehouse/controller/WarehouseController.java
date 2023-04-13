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
import com.tyss.warehouse.boot.warehouse.entity.Warehouse;
import com.tyss.warehouse.boot.warehouse.service.WarehouseService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
	@Autowired
	private WarehouseService service;
	@ApiOperation(value = "Save warehouse", notes = "API is used to save warehouse")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 400, message = "Id not found for the given  warehouse ID") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Warehouse>> saveWarehouse(@Valid @RequestBody Warehouse warehouse){
		return service.saveWarehouse(warehouse);
	}
	@ApiOperation(value = "update warehouse", notes = "API is used to update warehouse")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 400, message = "Id not found for the given  warehouse ID") })
	@PutMapping
	public ResponseEntity<ResponseStructure<Warehouse>> updateWarehouse(@Valid @RequestBody Warehouse warehouse, @RequestParam int warehouseid){
		return service.updateWarehouse(warehouse, warehouseid);
	}
	@ApiOperation(value = "get warehouse", notes = "API is used to find warehouse")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully found"),
			@ApiResponse(code = 400, message = "Id not found for the given  warehouse ID") })
	@GetMapping
	public ResponseEntity<ResponseStructure<Warehouse>> getWarehouse(@RequestParam int warehouseid){
		return service.findWarehouse(warehouseid);
	}
	@ApiOperation(value = "delete warehouse", notes = "API is used to delete warehouse")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully deleted"),
			@ApiResponse(code = 400, message = "Id not found for the given  warehouse ID") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Warehouse>> deleteWarehouse(@RequestParam int warehouseid){
		return service.deleteWarehouse(warehouseid);
	}
	
	
	
}
