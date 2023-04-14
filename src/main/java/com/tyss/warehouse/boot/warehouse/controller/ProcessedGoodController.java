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
import com.tyss.warehouse.boot.warehouse.entity.ProcessedGood;
import com.tyss.warehouse.boot.warehouse.service.ProcessedGoodService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/pgood")
public class ProcessedGoodController {
	@Autowired
	private ProcessedGoodService service;
	@ApiOperation(value = "Save processedgood", notes = "API is used to save processedgood")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 400, message = "Id not found for the given processed good ID") })
	@PostMapping
	public ResponseEntity<ResponseStructure<ProcessedGood>> savepGood(@Valid  @RequestBody ProcessedGood processedgood){
		return service.savePgood(processedgood);			
	}
	@ApiOperation(value = "update processedgood", notes = "API is used to update processedgood")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully updated"),
			@ApiResponse(code = 400, message = "Id not found for the given processed good ID") })
	@PutMapping
	public ResponseEntity<ResponseStructure<ProcessedGood>> updatepGood(@Valid @RequestBody ProcessedGood processedgood,@RequestParam int processedgoodid){
		return service.updatePgood(processedgood, processedgoodid);
	}
	@ApiOperation(value = "find processedgood", notes = "API is used to find processedgood")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully found"),
			@ApiResponse(code = 400, message = "Id not found for the given processed good ID") })
	@GetMapping
	public ResponseEntity<ResponseStructure<ProcessedGood>> findpGood(@RequestParam int processedgoodid){
		return service.findPgood(processedgoodid);
	}
	@ApiOperation(value = "delete processedgood", notes = "API is used to delete processedgood")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully deleted"),
			@ApiResponse(code = 400, message = "Id not found for the given processed good ID") })
	@DeleteMapping
	public ResponseEntity<ResponseStructure<ProcessedGood>> deletepGood(@RequestParam int processedgoodid){
		return service.deletePgood(processedgoodid);
	}
	@ApiOperation(value = "find processedgood by name", notes = "API is used to find processedgood by name")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully found"),
			@ApiResponse(code = 400, message = "processed good not found for the given name") })
	@GetMapping("/getbyname")
	public ResponseEntity<ResponseStructure<ProcessedGood>> findProcessedGoodByName(@Valid @RequestParam String ProcessedGoodName){
		return service.findProcessedGoodByName(ProcessedGoodName);
	}
	@ApiOperation(value = "find all processedgood", notes = "API is used to find all processedgood")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully found"),
			@ApiResponse(code = 400, message = "no items found") })
	@GetMapping("/getall")
	public ResponseEntity<ResponseStructure<List<ProcessedGood>>> getAllGoods(){
		return service.getAllGood();
	}
	@ApiOperation(value = "find all expired processedgood", notes = "API is used to find expired processedgood")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully found"),
			@ApiResponse(code = 400, message = "no expired items found") })
	@GetMapping("/expired")
	public ResponseEntity<ResponseStructure<List<ProcessedGood>>> getallExpiredItems(){
		return service.expiredGoods();
	}
}
