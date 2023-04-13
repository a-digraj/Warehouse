package com.tyss.warehouse.boot.warehouse.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.warehouse.boot.warehouse.entity.Admin;
import com.tyss.warehouse.boot.warehouse.entity.User;
import com.tyss.warehouse.boot.warehouse.repo.AdminRepo;
@Repository
public class AdminDao {
	@Autowired
	private AdminRepo repo;
	@Autowired
	private UserDao udao;
	
	public Admin saveAdmin(Admin admin) {
		return repo.save(admin);
		
	}
	public Admin updateAdmin(Admin admin,int id) {
		Optional<Admin> admin2 = repo.findById(id);
		if(admin2.isPresent()) {
			admin.setAdminId(id);
			return repo.save(admin);
		}
		return null;
	}
	public Admin getAdminById(int id) {
		Optional<Admin> admin = repo.findById(id);
		if(admin.isPresent()) {
			return admin.get();
		}
		return null;
	}
	public long checkAdmin() {
		return repo.checkAdmin();
	}
	public Admin deleteAdmin(int id) {
		Optional<Admin> admin= repo.findById(id);
		if(admin.isPresent()) {
			repo.deleteById(id); 
			return admin.get();
		}
		return null;
	
	}
	
	public List<User> allUsers(){
		List<User> users =  udao.findAllUsers();
		if(users!=null) {
			return users;
		}
		else{
			return null;
		}
	}
	public Admin findbyNameAndPassword(String name,String password) {
		Admin admin= repo.findAdminByNameandPassword(name, password);
		if(admin!=null) {
			return admin;
		}
		else {
			return null;
		}
	}
}
