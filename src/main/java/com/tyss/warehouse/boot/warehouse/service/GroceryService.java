package com.tyss.warehouse.boot.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.tyss.warehouse.boot.warehouse.config.ResponseStructure;
import com.tyss.warehouse.boot.warehouse.dao.GroceryDao;
import com.tyss.warehouse.boot.warehouse.entity.Grocery;
import com.tyss.warehouse.boot.warehouse.exception.IdNotFoundException;

@Service
public class GroceryService {
	@Autowired
	private GroceryDao dao;
	
	public ResponseEntity<ResponseStructure<Grocery>> saveGrocery(@RequestBody Grocery grocery){
	
		ResponseStructure<Grocery> responseStructure = new ResponseStructure<>();
		responseStructure.setData(dao.saveGrocery(grocery));
		responseStructure.setMessage("grocery saved successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		return new  ResponseEntity<ResponseStructure<Grocery>>(responseStructure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Grocery>> updateGrocery(@RequestBody Grocery grocery, @RequestParam int id){
		Grocery grocery2 = dao.findGrocery(id);
		if(grocery2!=null) {
		ResponseStructure<Grocery> responseStructure = new ResponseStructure<>();
		responseStructure.setData(dao.updateGrocery(grocery, id));
		responseStructure.setMessage("grocery updated successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		return new  ResponseEntity<ResponseStructure<Grocery>>(responseStructure,HttpStatus.OK);
		}
		else{
			throw new IdNotFoundException("grocery id not found");
		}
	}
	public ResponseEntity<ResponseStructure<Grocery>> findGrocery(@RequestParam int id){
		Grocery grocery2 = dao.findGrocery(id);
		if(grocery2!=null) {
		ResponseStructure<Grocery> responseStructure = new ResponseStructure<>();
		responseStructure.setData(dao.findGrocery(id));
		responseStructure.setMessage("grocery found");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		return new  ResponseEntity<ResponseStructure<Grocery>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new IdNotFoundException("grocery id not found");

		}
	}
	
	public ResponseEntity<ResponseStructure<Grocery>> deleteGrocery(@RequestParam int id){
		Grocery grocery = dao.findGrocery(id);
		if(grocery!=null) {
		ResponseStructure<Grocery> responseStructure = new ResponseStructure<>();
		responseStructure.setData(dao.deleteGrocery(id));
		responseStructure.setMessage("grocery deleted");
		responseStructure.setStatus(HttpStatus.OK.value());
		return new  ResponseEntity<ResponseStructure<Grocery>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("grocery id not found");
		}
		
	}
}
