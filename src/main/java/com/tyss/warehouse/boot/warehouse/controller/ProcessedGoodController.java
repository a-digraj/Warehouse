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
import com.tyss.warehouse.boot.warehouse.entity.ProcessedGood;
import com.tyss.warehouse.boot.warehouse.service.ProcessedGoodService;

@RestController
@RequestMapping("/pgood")
public class ProcessedGoodController {
	@Autowired
	private ProcessedGoodService service;
	@PostMapping
	public ResponseEntity<ResponseStructure<ProcessedGood>> savepGood(@RequestBody ProcessedGood pGood){
		return service.savePgood(pGood);			
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<ProcessedGood>> updatepGood(@RequestBody ProcessedGood pGood,@RequestParam int id){
		return service.updatePgood(pGood, id);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<ProcessedGood>> findpGood(@RequestParam int id){
		return service.findPgood(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<ProcessedGood>> deletepGood(@RequestParam int id){
		return service.deletePgood(id);
	}
}
