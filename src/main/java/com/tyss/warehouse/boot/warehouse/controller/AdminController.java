package com.tyss.warehouse.boot.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService service;
	@PostMapping
	public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(@RequestBody Admin admin){
		return service.saveAdmin(admin);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(@RequestBody Admin admin, @RequestParam int id){
		return service.updateAdmin(admin, id);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<AdminDto>> getAdmin(@RequestParam int id){
		return service.getAdminById(id);
	}
	
}
