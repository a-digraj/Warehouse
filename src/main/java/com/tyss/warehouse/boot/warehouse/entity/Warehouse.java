package com.tyss.warehouse.boot.warehouse.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;
@Entity
@Data
public class Warehouse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int warehouseId;
	@NotNull(message="warehouse address cannot be null")
	@NotBlank(message="warehouse address cannot be empty")
	private String warehouseAddress;
	@Min(value= 6000000000l, message = " phone number must be valid" )
	@Max(value= 9999999999l, message = " phone number must be valid" )
	private long warehouseNumber;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ProcessedGood> processedGoods;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Grocery> groceries;	
}
