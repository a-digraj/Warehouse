package com.tyss.warehouse.boot.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tyss.warehouse.boot.warehouse.entity.Warehouse;

public interface WarehouseRepo extends JpaRepository<Warehouse, Integer> {
	
	@Query("select count(*) from Warehouse w")
	public long warehouseCount();
	
}
