package com.tyss.warehouse.boot.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.warehouse.boot.warehouse.config.ResponseStructure;
import com.tyss.warehouse.boot.warehouse.dao.WarehouseDao;
import com.tyss.warehouse.boot.warehouse.entity.Warehouse;

@Service
public class WarehouseService {
	@Autowired
	private WarehouseDao dao;
	
	public ResponseEntity<ResponseStructure<Warehouse>> saveWarehouse(Warehouse warehouse){
		
		ResponseStructure<Warehouse> responseStructure = new ResponseStructure<>();
		responseStructure.setData(dao.addWarehouse(warehouse));
		responseStructure.setMessage("warehouse has been saved successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Warehouse>>(responseStructure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Warehouse>> updateWarehouse(Warehouse warehouse,int id){
		ResponseStructure<Warehouse> responseStructure = new ResponseStructure<>();
		responseStructure.setData(dao.updateWarehouse(warehouse, id));
		responseStructure.setMessage("warehouse has been updated successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Warehouse>>(responseStructure,HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<Warehouse>> findWarehouse(int id){
		ResponseStructure<Warehouse> responseStructure = new ResponseStructure<>();
		responseStructure.setData(dao.findWarehouseById(id));
		responseStructure.setMessage("warehouse has been found");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Warehouse>>(responseStructure,HttpStatus.FOUND);
	}
	public ResponseEntity<ResponseStructure<Warehouse>> deleteWarehouse(int id){
		ResponseStructure<Warehouse> responseStructure = new ResponseStructure<>();
		responseStructure.setData(dao.deleteWarehouse(id));
		responseStructure.setMessage("warehouse has been deleted");
		responseStructure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Warehouse>>(responseStructure,HttpStatus.OK);
	}
}
