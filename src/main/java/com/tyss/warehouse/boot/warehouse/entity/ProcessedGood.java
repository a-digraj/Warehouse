package com.tyss.warehouse.boot.warehouse.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;
@Data
@Entity
public class ProcessedGood {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int processedGoodId;
	@NotNull(message = "name of processed goods cannot be null or empty")
	@NotEmpty(message = "name of processed goods cannot be null or empty")
	private String processedGoodName;
	@NotEmpty(message = "manufactured date cannot be empty for processed goods")
	private String  processedGoodmfgDate;
	@NotEmpty(message = "expiry date cannot be empty")
	private String processedGoodExpDate;
	@Positive(message = "Value must be positive")
	private double processedGoodPrice;
	@Positive(message = "Value must be positive")
	private int processedGoodQuantity;
	
	
	
	
}
