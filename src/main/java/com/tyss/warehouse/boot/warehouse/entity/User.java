
package com.tyss.warehouse.boot.warehouse.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@NotNull(message = "name of user cannot be null")
	@NotBlank(message = "name of user cannot be null")
	private String userName;
	@NotNull(message = "password for user cannot be empty")
	@NotBlank(message = "password for user cannot be empty")
	private String userPassword;
	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;
		
}
