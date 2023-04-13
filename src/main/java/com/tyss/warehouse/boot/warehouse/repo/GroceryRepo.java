package com.tyss.warehouse.boot.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tyss.warehouse.boot.warehouse.entity.Grocery;

public interface GroceryRepo extends JpaRepository<Grocery,Integer> {
	@Query("select g from Grocery g where g.groceryName = :name")
	public Grocery findGroceryByName(@Param("name") String name);
	
}
