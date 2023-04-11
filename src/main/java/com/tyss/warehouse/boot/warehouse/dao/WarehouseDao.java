package com.tyss.warehouse.boot.warehouse.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tyss.warehouse.boot.warehouse.entity.Warehouse;
import com.tyss.warehouse.boot.warehouse.repo.WarehouseRepo;
@Component
public class WarehouseDao {
	@Autowired
	private WarehouseRepo repo;
	
	public Warehouse addWarehouse(Warehouse warehouse) {
		return repo.save(warehouse);
	}
	public Warehouse updateWarehouse(Warehouse warehouse, int id) {
		Optional<Warehouse> warehouse2 = repo.findById(id);
		if(warehouse2.isPresent()) {
			warehouse.setWarehouseId(id);
			return repo.save(warehouse);
		}
		return null;
	}
	public Warehouse findWarehouseById(int id) {
		Optional<Warehouse> warehouse = repo.findById(id);
		if(warehouse.isPresent()) {
			return warehouse.get();
		}
		return null;
	}
	public Warehouse deleteWarehouse(int id) {
		Optional<Warehouse> warehouse = repo.findById(id);
		if(warehouse.isPresent()) {
			repo.delete(warehouse.get());
			return warehouse.get();
		}
		return null;
	}
	
}
