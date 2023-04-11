package com.tyss.warehouse.boot.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.warehouse.boot.warehouse.entity.ProcessedGood;

public interface ProcessedGoodRepo extends JpaRepository<ProcessedGood, Integer> {

}
