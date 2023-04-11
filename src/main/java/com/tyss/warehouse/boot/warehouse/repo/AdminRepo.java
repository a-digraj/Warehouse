package com.tyss.warehouse.boot.warehouse.repo;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tyss.warehouse.boot.warehouse.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{
	
	
	@Query("SELECT COUNT(a) FROM Admin a")
	public long checkAdmin();
	
	
}
