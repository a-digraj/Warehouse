package com.tyss.warehouse.boot.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.warehouse.boot.warehouse.entity.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer> {

}
