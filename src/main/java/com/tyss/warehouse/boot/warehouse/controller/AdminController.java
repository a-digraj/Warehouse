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
import com.tyss.warehouse.boot.warehouse.dto.AdminDto;
import com.tyss.warehouse.boot.warehouse.entity.Admin;
import com.tyss.warehouse.boot.warehouse.service.AdminService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService service;
	@ApiOperation(value = "Save Admin", notes = "API is used to save Admin")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 400, message = "Id not found for the given admin ID") })
	@PostMapping
	public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(@Valid  @RequestBody Admin admin){
		return service.saveAdmin(admin);
	}
	@ApiOperation(value = "Update Admin", notes = "API is used to update Admin for given admin Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "succesfully updated"),
			@ApiResponse(code = 400, message = "Id not found for the given admin ID") })
	@PutMapping
	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(@Valid @RequestBody Admin admin, @RequestParam int adminid){
		return service.updateAdmin(admin, adminid);
	}
	@ApiOperation(value = "get Admin", notes = "API is used to get Admin for admin Id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Admin is fetched"),
			@ApiResponse(code = 400, message = "Id not found for the given admin ID") })
	@GetMapping
	public ResponseEntity<ResponseStructure<AdminDto>> getAdmin(@RequestParam int adminid){
		return service.getAdminById(adminid);
	}
	@ApiOperation(value = "Delete Admin", notes = "API is used to delete Admin for given Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "succesfully deleted"),
			@ApiResponse(code = 400, message = "Id not found for the given admin ID") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<AdminDto>> deleteAdmin(@RequestParam int adminid){
		return service.deleteAdmin(adminid);
	}
	
	@ApiOperation(value = "get Admin", notes = "API is used to get Admin for admin Id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "Admin is fetched"),
			@ApiResponse(code = 400, message = "wrong input for admin") })
	@GetMapping("/login")
	public ResponseEntity<ResponseStructure<AdminDto>> loginByNameAndPassword(@RequestParam String name, @RequestParam String password ){
		return service.findbyNameAndPassword(name, password);
	}
}
