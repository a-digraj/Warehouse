package com.tyss.warehouse.boot.warehouse.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.warehouse.boot.warehouse.entity.Admin;
import com.tyss.warehouse.boot.warehouse.repo.AdminRepo;
@Repository
public class AdminDao {
	@Autowired
	private AdminRepo repo;

	
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
	
	
}
