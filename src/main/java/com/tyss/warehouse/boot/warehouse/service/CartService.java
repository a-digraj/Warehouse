package com.tyss.warehouse.boot.warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.warehouse.boot.warehouse.config.ResponseStructure;
import com.tyss.warehouse.boot.warehouse.dao.CartDao;
import com.tyss.warehouse.boot.warehouse.entity.Cart;
import com.tyss.warehouse.boot.warehouse.entity.Grocery;
import com.tyss.warehouse.boot.warehouse.entity.ProcessedGood;
import com.tyss.warehouse.boot.warehouse.exception.ApplicationHandler;
import com.tyss.warehouse.boot.warehouse.exception.IdNotFoundException;

@Service
public class CartService {
	@Autowired
	private CartDao dao;

	public ResponseEntity<ResponseStructure<Cart>> saveCart(Cart cart) {
		ResponseStructure<Cart> responseStructure = new ResponseStructure<>();

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
		cart.setCartCost(cost);

		responseStructure.setData(dao.addCart(cart));
		responseStructure.setMessage("cart savced successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Cart>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Cart>> updateCart(Cart cart, int id) {
		Cart cart2 = dao.findCartById(id);
		if(cart2!=null) {
		ResponseStructure<Cart> responseStructure = new ResponseStructure<>();
		responseStructure.setData(dao.updateCart(cart, id));
		responseStructure.setMessage("cart updated successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Cart>>(responseStructure, HttpStatus.OK);
		}
		throw new IdNotFoundException("cart id not found");
	}

	public ResponseEntity<ResponseStructure<Cart>> findCart(int id) {
		Cart cart2 = dao.findCartById(id);
		if(cart2!=null) {
		ResponseStructure<Cart> responseStructure = new ResponseStructure<>();
		responseStructure.setData(dao.findCartById(id));
		responseStructure.setMessage("cart found");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<Cart>>(responseStructure, HttpStatus.FOUND);
		}
		throw new IdNotFoundException("cart id not found");
	}

	public ResponseEntity<ResponseStructure<Cart>> deleteCart(int id) {
		
		ResponseStructure<Cart> responseStructure = new ResponseStructure<>();
		Cart cart = dao.deleteCartById(id);
		if (cart != null) {
			responseStructure.setData(cart);
			responseStructure.setMessage("cart deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Cart>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setMessage("cart id not found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Cart>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

}
