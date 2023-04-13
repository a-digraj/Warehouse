package com.tyss.warehouse.boot.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tyss.warehouse.boot.warehouse.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	@Query("select u from User u where u.userName = :name")
	public User findUserByName(@Param("name") String name);
}
