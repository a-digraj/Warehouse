package com.tyss.warehouse.boot.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.warehouse.boot.warehouse.config.ResponseStructure;
import com.tyss.warehouse.boot.warehouse.dao.WarehouseDao;
import com.tyss.warehouse.boot.warehouse.entity.Warehouse;
import com.tyss.warehouse.boot.warehouse.exception.IdNotFoundException;
import com.tyss.warehouse.boot.warehouse.exception.WarehouseAlreadyExistException;
import com.tyss.warehouse.boot.warehouse.repo.WarehouseRepo;

@Service
public class WarehouseService {
	@Autowired
	private WarehouseDao dao;
	@Autowired
	private WarehouseRepo repo;
	
	public ResponseEntity<ResponseStructure<Warehouse>> saveWarehouse(Warehouse warehouse){
		
		long warehousenum = repo.warehouseCount();
		if(warehousenum<0) {
		
		ResponseStructure<Warehouse> responseStructure = new ResponseStructure<>();
		responseStructure.setData(dao.addWarehouse(warehouse));
		responseStructure.setMessage("warehouse has been saved successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Warehouse>>(responseStructure,HttpStatus.CREATED);
		}
		else {
			throw new WarehouseAlreadyExistException("warehouse already present");
		}
	}
	public ResponseEntity<ResponseStructure<Warehouse>> updateWarehouse(Warehouse warehouse,int id){
		Warehouse warehouse2 = dao.findWarehouseById(id);
		if(warehouse2!=null) {
			ResponseStructure<Warehouse> responseStructure = new ResponseStructure<>();
			responseStructure.setData(dao.updateWarehouse(warehouse, id));
			responseStructure.setMessage("warehouse has been updated successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Warehouse>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("warehouse not found for given id");
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Warehouse>> findWarehouse(int id){
		
		Warehouse warehouse = dao.findWarehouseById(id);
		if(warehouse!=null) {
			ResponseStructure<Warehouse> responseStructure = new ResponseStructure<>();
			responseStructure.setData(dao.findWarehouseById(id));
			responseStructure.setMessage("warehouse has been found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Warehouse>>(responseStructure,HttpStatus.FOUND);
		}
		else {
			throw new IdNotFoundException("warehouse id not found");
		}
		
		
	}
	public ResponseEntity<ResponseStructure<Warehouse>> deleteWarehouse(int id){
		Warehouse warehouse = dao.findWarehouseById(id);
		if(warehouse!=null) {
			ResponseStructure<Warehouse> responseStructure = new ResponseStructure<>();
			responseStructure.setData(dao.deleteWarehouse(id));
			responseStructure.setMessage("warehouse has been deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Warehouse>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("warehouse not found");
		}
	}
	public ResponseEntity<ResponseStructure<Warehouse>> addGroceryToWarehouse(int warehouseid, int groceryid){
		Warehouse warehouse = dao.addGroceryToWarehouse(warehouseid, groceryid);
		if(warehouse!=null) {
			ResponseStructure<Warehouse> responseStructure = new ResponseStructure<>();
			responseStructure.setData(warehouse);
			responseStructure.setMessage("grocery has been added");
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Warehouse>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("warehouse not found");
		}
	}
}
