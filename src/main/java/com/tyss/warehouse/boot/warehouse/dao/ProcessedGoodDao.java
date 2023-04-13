package com.tyss.warehouse.boot.warehouse.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.warehouse.boot.warehouse.entity.ProcessedGood;
import com.tyss.warehouse.boot.warehouse.repo.ProcessedGoodRepo;
@Repository
public class ProcessedGoodDao {
	@Autowired
	private ProcessedGoodRepo repo;
	
	public ProcessedGood addprocessedgood(ProcessedGood processedgood) {
		return repo.save(processedgood);
	}
	public ProcessedGood updateprocessedgood(ProcessedGood processedgood, int id) {
		Optional<ProcessedGood> processedgood2 = repo.findById(id);
		if(processedgood2.isPresent()) {
			processedgood.setProcessedGoodId(id);
			return repo.save(processedgood);
		}
		return null;
	}
	public ProcessedGood findprocessedgoodById(int id) {
		Optional<ProcessedGood> processedgood = repo.findById(id);
		if(processedgood.isPresent()) {
			return processedgood.get();
		}
		return null;
	}
	public ProcessedGood deleteprocessedgoodById(int id) {
		Optional<ProcessedGood> processedgood = repo.findById(id);
		if(processedgood.isPresent()){
			repo.delete(processedgood.get());
			return processedgood.get();
		}
		return null;
	}
	
	public ProcessedGood findByName(String name) {
		ProcessedGood good = repo.findProcessedGoodByName(name);
		if(good!=null) {
			return good;
		}
		else {
			return null;
		}
	}
	
	public List<ProcessedGood> getAllGoods(){
		List<ProcessedGood> goods = repo.findAll();
		if(goods!=null) {
			return goods;
		}
		else {
			return null;
		}
	
	}
	
	
}
