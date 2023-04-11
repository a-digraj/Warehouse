package com.tyss.warehouse.boot.warehouse.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.warehouse.boot.warehouse.entity.Grocery;
import com.tyss.warehouse.boot.warehouse.repo.GroceryRepo;
@Repository
public class GroceryDao {
	@Autowired
	private GroceryRepo repo;
	
	public Grocery saveGrocery(Grocery grocery) {
		return repo.save(grocery);
	}
	public Grocery updateGrocery(Grocery grocery, int id) {
		Optional<Grocery> grocery2 = repo.findById(id);
		if(grocery2.isPresent()) {
			grocery.setgId(id);
			return repo.save(grocery);
		}
		return null;
	}
	public Grocery findGrocery(int id) {
		Optional<Grocery> grocery = repo.findById(id);
		if(grocery.isPresent()) {
			return grocery.get();
		}
		return null;
	}
	public Grocery deleteGrocery(int id) {
		Optional<Grocery> grocery = repo.findById(id);
		if(grocery.isPresent()) {
			repo.deleteById(id);
			return grocery.get();
		}
		return null;
	}
}
