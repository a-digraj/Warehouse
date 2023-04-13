package com.tyss.warehouse.boot.warehouse.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
@Entity

@Data
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<ProcessedGood> processedGoods;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Grocery> groceries;
	private double cartCost;

	
	
}
