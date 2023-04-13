package com.tyss.warehouse.boot.warehouse.entity;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	@NotNull(message = "admin name cannot be null")
	@NotBlank(message = "admin name cannot be null")
	private String adminName;
	@Min(value= 6000000000l, message = " phone number must be valid" )
	@Max(value= 9999999999l, message = " phone number must be valid" )
	private long adminPhone;
	@NotBlank(message = "Password is required")
	@Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$", message = "must contain at least one letter, one number, one special character")
	private String adminPassword;
	@OneToOne(cascade = CascadeType.ALL)
	private Warehouse warehouse;
	

}
