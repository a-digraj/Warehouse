package com.tyss.warehouse.boot.warehouse.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tyss.warehouse.boot.warehouse.entity.Grocery;
import com.tyss.warehouse.boot.warehouse.entity.ProcessedGood;
import com.tyss.warehouse.boot.warehouse.entity.Warehouse;
import com.tyss.warehouse.boot.warehouse.repo.GroceryRepo;
import com.tyss.warehouse.boot.warehouse.repo.ProcessedGoodRepo;
import com.tyss.warehouse.boot.warehouse.repo.WarehouseRepo;
@Component
public class WarehouseDao {
	@Autowired
	private WarehouseRepo repo;
	@Autowired
	private GroceryRepo grepo;
	@Autowired
	private ProcessedGoodRepo prepo;
	
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
	public Warehouse addGroceryToWarehouse(int warehouseid, int groceryid) {
		Optional<Warehouse> warehouse = repo.findById(warehouseid);
		Optional<Grocery> grocery = grepo.findById(groceryid);
		if(warehouse.get()!=null && grocery.get()!=null) {
			List<Grocery> groceries = warehouse.get().getGroceries();
			groceries.add(grocery.get());
			return updateWarehouse(warehouse.get(),warehouse.get().getWarehouseId());
		}
		else return null;
	}
	public Warehouse addProcessedGoodToWarehouse(int warehouseid,int processedGoodId) {
		Optional<Warehouse> warehouse =  repo.findById(warehouseid);
		Optional<ProcessedGood> pgoods = prepo.findById(processedGoodId);
		if(warehouse.get()!=null && pgoods.get()!=null) {
			List<ProcessedGood> goods = warehouse.get().getProcessedGoods();
			goods.add(pgoods.get());
			return updateWarehouse(warehouse.get(), warehouse.get().getWarehouseId());
		}
		else {
			return null;
		}
	}
	
}
