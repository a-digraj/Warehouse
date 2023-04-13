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
import com.tyss.warehouse.boot.warehouse.exception.UserAlreadyExistsException;
import com.tyss.warehouse.boot.warehouse.exception.UserCredentialsInvalid;
import com.tyss.warehouse.boot.warehouse.exception.UserIdnotFoundException;
import com.tyss.warehouse.boot.warehouse.exception.UserNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	@Autowired
	private UserDto dto;

	public ResponseEntity<ResponseStructure<UserDto>> saveUser(User user) {
		User user3 = dao.findUserByName(user.getUserName());

		if(user3==null) {
			Cart cart = user.getCart();

			if (cart.getGroceries() != null && cart.getProcessedGoods() != null) {

				// to display total cost of items in the cart
				List<Grocery> groceries = cart.getGroceries();
				double cost = 0;
				for (Grocery g : groceries) {
					cost = cost + (g.getQuantity() * g.getGroceryPrice());

				}
				List<ProcessedGood> processedGoods = cart.getProcessedGoods();
				for (ProcessedGood processedgoodsgoods : processedGoods) {
					cost = cost + ((processedgoodsgoods.getProcessedGoodPrice()
							* processedgoodsgoods.getProcessedGoodQuantity()));
				}

				user.getCart().setCartCost(cost);

				User user2 = dao.saveUser(user);
				dto.setUserId(user2.getUserId());
				dto.setCart(user2.getCart());
				dto.setUserName(user2.getUserName());

				dto.getCart().setCartCost(cost);
				ResponseStructure<UserDto> responseStructure = new ResponseStructure<>();
				responseStructure.setData(dto);
				responseStructure.setMessage("user save successfully");
				responseStructure.setStatus(HttpStatus.CREATED.value());
				return new ResponseEntity<ResponseStructure<UserDto>>(responseStructure, HttpStatus.CREATED);
			}
			else {
				User user2 =  dao.saveUser(user);
				dto.setCart(user2.getCart());
				dto.setCart(user2.getCart());
				dto.setUserName(user2.getUserName());
				ResponseStructure<UserDto> responseStructure = new ResponseStructure<>();
				responseStructure.setData(dto);
				responseStructure.setMessage("user save successfully with no items in cart");
				responseStructure.setStatus(HttpStatus.CREATED.value());
				return new ResponseEntity<ResponseStructure<UserDto>>(responseStructure, HttpStatus.CREATED);
			}
		}
		else {
			throw new UserAlreadyExistsException("user with this name already exists");
		}
	
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

	public ResponseEntity<ResponseStructure<List<UserDto>>> findAllUsers() {
		List<User> users = dao.findAllUsers();
		List<UserDto> dtos = new ArrayList<>();

		if (users != null) {
			for (User u : users) {
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

			return new ResponseEntity<ResponseStructure<List<UserDto>>>(structure, HttpStatus.FOUND);
		} else {
			throw new UserIdnotFoundException("users not found ");
		}
	}

	public ResponseEntity<ResponseStructure<UserDto>> findUserByName(String name) {
		User user = dao.findUserByName(name);
		if (user != null) {
			dto.setCart(user.getCart());
			dto.setUserId(user.getUserId());
			dto.setUserName(user.getUserName());

			ResponseStructure<UserDto> responseStructure = new ResponseStructure<>();
			responseStructure.setData(dto);
			responseStructure.setMessage("user found");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<UserDto>>(responseStructure, HttpStatus.FOUND);
		} else
			throw new UserCredentialsInvalid("wrong user credentials");

	}

	public ResponseEntity<ResponseStructure<Cart>> deleteCartFromUser(int userId) {
		Cart cart = dao.deleteCartFromUser(userId);
		if (cart != null) {
			ResponseStructure<Cart> structure = new ResponseStructure<>();
			structure.setData(cart);
			structure.setMessage("cart deleted success");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Cart>>(structure, HttpStatus.OK);
		} else {
			throw new UserNotFoundException("no user found");
		}
	}

}
