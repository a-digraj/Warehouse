package com.tyss.warehouse.boot.warehouse.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tyss.warehouse.boot.warehouse.entity.Cart;
import com.tyss.warehouse.boot.warehouse.entity.User;
import com.tyss.warehouse.boot.warehouse.repo.UserRepo;

@Component
public class UserDao {
	@Autowired
	private UserRepo repo;
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	public User updateUser(User user, int id) {
		Optional<User> user2 = repo.findById(id);
		if(user2.isPresent()){
			user.setUserId(id);
			return repo.save(user);
		}
		return null;
	}
	public User findUserById(int id) {
		Optional<User> user = repo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}
	public User deleteUserById(int id) {
		Optional<User> user = repo.findById(id);
		if(user.isPresent()) {
			repo.delete(user.get());
			return user.get();
		}
		return null;
	}
	public List<User> findAllUsers(){
		List<User> users = repo.findAll();
		if(!users.isEmpty()) {
			return users;
		}
		return null;
	}
	public User findUserByName(String name) {
		User user = repo.findUserByName(name);
		if(user!=null) {
			return user;
		}else {
			return null;
		}
	}
	
	public Cart deleteCartFromUser(int userId) {
		User user = findUserById(userId);
			if(user!=null) {
				return deleteUserById(userId).getCart();
			}
			else {
				return null;
			}
	}
	 
	
}
