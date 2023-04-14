package com.tyss.warehouse.boot.warehouse.entity;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate  processedGoodmfgDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate processedGoodExpDate;
	@Positive(message = "Value must be positive")
	private double processedGoodPrice;
	@Positive(message = "Value must be positive")
	private int processedGoodQuantity;

}
