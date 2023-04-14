package com.tyss.warehouse.boot.warehouse.controller;

import java.util.List;

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
import com.tyss.warehouse.boot.warehouse.entity.Grocery;
import com.tyss.warehouse.boot.warehouse.service.GroceryService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/grocery")
public class GroceryController {

	@Autowired
	private GroceryService service;

	@ApiOperation(value = "Save grocery", notes = "API is used to save grocery")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 400, message = "Id not found for the given grocery ID") })
	@PostMapping
	public ResponseEntity<ResponseStructure<Grocery>> saveGrocery(@Valid  @RequestBody Grocery grocery) {
		return service.saveGrocery(grocery);
	}

	@ApiOperation(value = "update grocery", notes = "API is used to update grocery")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 400, message = "Id not found for the given grocery ID") })
	@PutMapping
	public ResponseEntity<ResponseStructure<Grocery>> updateGrocery(@Valid @RequestBody Grocery grocery,
			@RequestParam int groceryid) {
		return service.updateGrocery(grocery, groceryid);
				
	}

	@ApiOperation(value = "find grocery", notes = "API is used to find grocery")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully found"),
			@ApiResponse(code = 400, message = "Id not found for the given grocery ID") })
	@GetMapping
	public ResponseEntity<ResponseStructure<Grocery>> findGrocery( @RequestParam int groceryid) {
		return service.findGrocery(groceryid);
	}

	@ApiOperation(value = "Save grocery", notes = "API is used to delete grocery")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully deleted"),
			@ApiResponse(code = 400, message = "Id not found for the given grocery ID") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Grocery>> deleteGrocery(@RequestParam int groceryid) {
		return service.deleteGrocery(groceryid);
	}
	@ApiOperation(value = "find grocery by name", notes = "API is used to find grocery")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully found"),
			@ApiResponse(code = 400, message = "name not found for the given grocery") })
	@GetMapping("/name")
	public ResponseEntity<ResponseStructure<Grocery>> findGroceryByName(@Valid @RequestParam String groceryname){
		return service.findGroceryByAdmin(groceryname);
	}
	@ApiOperation(value = "find groceries", notes = "API is used to find all grocery")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully found"),
			@ApiResponse(code = 400, message = "no groceries found") })
	@GetMapping("/getall")
	public ResponseEntity<ResponseStructure<List<Grocery>>> findAllGrocery(){
		return service.findAllGrocery();
	}

}
