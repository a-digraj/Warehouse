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
import com.tyss.warehouse.boot.warehouse.exception.GroceryAlreadyPresent;
import com.tyss.warehouse.boot.warehouse.exception.GroceryNotFoundByName;
import com.tyss.warehouse.boot.warehouse.exception.IdNotFoundException;

@Service
public class GroceryService {
	@Autowired
	private GroceryDao dao;

	public ResponseEntity<ResponseStructure<Grocery>> saveGrocery(Grocery grocery) {
		String name= grocery.getGroceryName();
		if(dao.findGroceryByName(name)==null) {
		ResponseStructure<Grocery> responseStructure = new ResponseStructure<>();
		responseStructure.setData(dao.saveGrocery(grocery));
		responseStructure.setMessage("grocery saved successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Grocery>>(responseStructure, HttpStatus.CREATED);
		}
		else {
			throw new GroceryAlreadyPresent("grocery already exists");
		}
	}

	public ResponseEntity<ResponseStructure<Grocery>> updateGrocery(Grocery grocery, int id) {
		Grocery grocery2 = dao.findGrocery(id);
		if (grocery2 != null) {
			ResponseStructure<Grocery> responseStructure = new ResponseStructure<>();
			responseStructure.setData(dao.updateGrocery(grocery, id));
			responseStructure.setMessage("grocery updated successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Grocery>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("grocery id not found");
		}
	}

	public ResponseEntity<ResponseStructure<Grocery>> findGrocery(int id) {
		Grocery grocery2 = dao.findGrocery(id);
		if (grocery2 != null) {
			ResponseStructure<Grocery> responseStructure = new ResponseStructure<>();
			responseStructure.setData(dao.findGrocery(id));
			responseStructure.setMessage("grocery found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Grocery>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException("grocery id not found");

		}
	}

	public ResponseEntity<ResponseStructure<Grocery>> deleteGrocery(int id) {
		Grocery grocery = dao.findGrocery(id);
		if (grocery != null) {
			ResponseStructure<Grocery> responseStructure = new ResponseStructure<>();
			responseStructure.setData(dao.deleteGrocery(id));
			responseStructure.setMessage("grocery deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Grocery>>(responseStructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("grocery id not found");
		}
	}
	
	public ResponseEntity<ResponseStructure<Grocery>> findGroceryByAdmin(String groceryName){
		Grocery grocery = dao.findGroceryByName(groceryName);
		if(grocery!=null) {
			ResponseStructure<Grocery> structure = new ResponseStructure<>();
			structure.setData(grocery);
			structure.setMessage("grocery found");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Grocery>>(structure,HttpStatus.FOUND);
		}
		else throw new GroceryNotFoundByName("grocery with name not found");
	}
}
