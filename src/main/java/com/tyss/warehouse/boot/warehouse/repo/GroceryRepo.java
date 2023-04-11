package com.tyss.warehouse.boot.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.warehouse.boot.warehouse.entity.Grocery;

public interface GroceryRepo extends JpaRepository<Grocery,Integer> {

}
