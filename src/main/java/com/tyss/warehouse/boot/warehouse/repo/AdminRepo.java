package com.tyss.warehouse.boot.warehouse.repo;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tyss.warehouse.boot.warehouse.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{
	
	
	@Query("SELECT COUNT(a) FROM Admin a")
	public long checkAdmin();
	
	@Query("SELECT a FROM Admin a WHERE a.adminName = :name AND a.adminPassword = :password")
	public Admin findAdminByNameandPassword(@Param("name") String name, @Param("password") String password);
	
	
	

	
}
