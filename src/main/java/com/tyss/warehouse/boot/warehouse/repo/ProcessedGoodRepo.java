package com.tyss.warehouse.boot.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tyss.warehouse.boot.warehouse.entity.Grocery;
import com.tyss.warehouse.boot.warehouse.entity.ProcessedGood;

public interface ProcessedGoodRepo extends JpaRepository<ProcessedGood, Integer> {
	
	@Query("select pg from ProcessedGood pg where pg.processedGoodName = :name")
	public ProcessedGood findProcessedGoodByName(@Param("name") String name);
	
	
}
