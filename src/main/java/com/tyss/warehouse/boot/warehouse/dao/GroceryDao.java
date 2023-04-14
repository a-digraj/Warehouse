package com.tyss.warehouse.boot.warehouse.dao;

import java.util.List;
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
		if (grocery!= null) {
			return repo.save(grocery);
		} 
		else {
		}
		return null;
	}

	public Grocery updateGrocery(Grocery grocery, int id) {
		Optional<Grocery> grocery2 = repo.findById(id);
		if (grocery2.isPresent()) {
			return repo.save(grocery);
		}
		return null;
	}

	public Grocery findGrocery(int id) {
		Optional<Grocery> grocery = repo.findById(id);
		if (grocery.isPresent()) {
			return grocery.get();
		}
		return null;
	}

	public Grocery deleteGrocery(int id) {
		Optional<Grocery> grocery = repo.findById(id);
		if (grocery.isPresent()) {
			repo.deleteById(id);
			return grocery.get();
		}
		return null;
	}
	public Grocery findGroceryByName(String groceryName) {
		Grocery grocery = repo.findGroceryByName(groceryName);
		if(grocery!=null){
			return grocery;
		}
		else {
			return null;
		}
	}
	public List<Grocery> findAllGrocery(){
		List<Grocery> groceries = repo.findAll();
		if(groceries!=null) {
			return groceries;
		}
		else {
			return null;
		}
	}
	
}
