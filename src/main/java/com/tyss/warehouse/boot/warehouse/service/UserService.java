package com.tyss.warehouse.boot.warehouse.service;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.warehouse.boot.warehouse.config.ResponseStructure;
import com.tyss.warehouse.boot.warehouse.dao.UserDao;
import com.tyss.warehouse.boot.warehouse.dto.UserDto;
import com.tyss.warehouse.boot.warehouse.entity.Cart;
import com.tyss.warehouse.boot.warehouse.entity.Grocery;
import com.tyss.warehouse.boot.warehouse.entity.ProcessedGood;
import com.tyss.warehouse.boot.warehouse.entity.User;
import com.tyss.warehouse.boot.warehouse.exception.UserIdnotFoundException;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	@Autowired
	private UserDto dto;

	public ResponseEntity<ResponseStructure<UserDto>> saveUser(User user) {

		Cart cart = user.getCart();

		// to display total cost of items in the cart
		List<Grocery> groceries = cart.getGroceries();
		double cost = 0;
		for (Grocery g : groceries) {
			cost = cost + (g.getQuantity() * g.getPrice());

		}
		List<ProcessedGood> pGoods = cart.getProcessedgoods();
		for (ProcessedGood pgoods : pGoods) {
			cost = cost + (pgoods.getPrice() * pgoods.getPgoodQuantity());
		}
		
		
		User user2 = dao.saveUser(user);
		dto.setUserId(user2.getUserId());
		dto.setCart(user2.getCart());
		dto.setUserName(user2.getUserName());
		
		//dto.setCart(user.getCart());
		dto.getCart().setCartCost(cost);
		

		ResponseStructure<UserDto> responseStructure = new ResponseStructure<>();
		responseStructure.setData(dto);
		responseStructure.setMessage("user save successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<UserDto>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<UserDto>> updateUser(User user, int id) {
		User user3 = dao.findUserById(id);
		if (user3 != null) {
			User user2 = dao.updateUser(user, id);
			dto.setCart(user2.getCart());
			dto.setUserId(user2.getUserId());
			dto.setUserName(user2.getUserName());

			ResponseStructure<UserDto> responseStructure = new ResponseStructure<>();
			responseStructure.setData(dto);
			responseStructure.setMessage("user updated successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<UserDto>>(responseStructure, HttpStatus.OK);
		} else {
			throw new UserIdnotFoundException("user id not found ");
		}

	}

	public ResponseEntity<ResponseStructure<UserDto>> findUser(int id) {
		User user = dao.findUserById(id);
		if (user != null) {
			User user2 = dao.findUserById(id);
			dto.setCart(user2.getCart());
			dto.setUserId(user2.getUserId());
			dto.setUserName(user2.getUserName());

			ResponseStructure<UserDto> responseStructure = new ResponseStructure<>();
			responseStructure.setData(dto);
			responseStructure.setMessage("user found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<UserDto>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new UserIdnotFoundException("user id not found ");
		}
	}

	public ResponseEntity<ResponseStructure<UserDto>> deleteUser(int id) {
		User user = dao.findUserById(id);
		if (user != null) {
			User user2 = dao.deleteUserById(id);
			dto.setCart(user2.getCart());
			dto.setUserId(user2.getUserId());
			dto.setUserName(user2.getUserName());

			ResponseStructure<UserDto> responseStructure = new ResponseStructure<>();
			responseStructure.setData(dto);
			responseStructure.setMessage("user DELETED");
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<UserDto>>(responseStructure, HttpStatus.OK);
		} else {
			throw new UserIdnotFoundException("user id not found ");
		}
	}
	public ResponseEntity<ResponseStructure<List<UserDto>>> findAllUsers(){
		List<User> users =  dao.findAllUsers();
		List<UserDto> dtos = new ArrayList<>();
		
		
		if(users!=null) {
			for(User u:users) {
				UserDto userDto = new UserDto();
				userDto.setCart(u.getCart());
				userDto.setUserId(u.getUserId());
				userDto.setUserName(u.getUserName());
				dtos.add(userDto);
			}
			ResponseStructure<List<UserDto>> structure = new ResponseStructure<>();
			structure.setData(dtos);
			structure.setMessage(" users found are ");
			structure.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<List<UserDto>>>(structure,HttpStatus.FOUND);	
		}
		else {
			throw new UserIdnotFoundException("user id not found ");
		}
	}

}
