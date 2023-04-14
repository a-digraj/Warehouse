package com.tyss.warehouse.boot.warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.warehouse.boot.warehouse.config.ResponseStructure;
import com.tyss.warehouse.boot.warehouse.dao.CartDao;
import com.tyss.warehouse.boot.warehouse.dao.GroceryDao;
import com.tyss.warehouse.boot.warehouse.dao.ProcessedGoodDao;
import com.tyss.warehouse.boot.warehouse.dao.UserDao;
import com.tyss.warehouse.boot.warehouse.entity.Cart;
import com.tyss.warehouse.boot.warehouse.entity.Grocery;
import com.tyss.warehouse.boot.warehouse.entity.ProcessedGood;
import com.tyss.warehouse.boot.warehouse.exception.ApplicationHandler;
import com.tyss.warehouse.boot.warehouse.exception.IdNotFoundException;

@Service
public class CartService {
	@Autowired
	private CartDao dao;
	@Autowired
	private GroceryDao groceryDao;
	@Autowired
	private ProcessedGoodDao processedGoodDao;
	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<Cart>> saveCart(Cart cart) {
		ResponseStructure<Cart> responseStructure = new ResponseStructure<>();

		// to display total cost of items in the cart
		List<Grocery> groceries = cart.getGroceries();
		double cost = 0;
		for (Grocery g : groceries) {
			cost = cost + (g.getQuantity() * g.getGroceryPrice());

		}
		List<ProcessedGood> pGoods = cart.getProcessedGoods();
		for (ProcessedGood pgoods : pGoods) {
			cost = cost + (pgoods.getProcessedGoodPrice() * pgoods.getProcessedGoodQuantity());
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
			List<Grocery> groceries = cart2.getGroceries();
			double cost = 0;
			for (Grocery g : groceries) {
				cost = cost + (g.getQuantity() * g.getGroceryPrice());

			}
			List<ProcessedGood> pGoods = cart2.getProcessedGoods();
			for (ProcessedGood pgoods : pGoods) {
				cost = cost + (pgoods.getProcessedGoodPrice() * pgoods.getProcessedGoodQuantity());
			}
			cart2.setCartCost(cost);
			updateCart(cart2, id);
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
		Cart cart = dao.findCartById(id);
		if (cart != null) {
		
			responseStructure.setData(dao.deleteCartById(id));
			responseStructure.setMessage("cart deleted");
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Cart>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setMessage("cart id not found");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Cart>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}
	public ResponseEntity<ResponseStructure<Cart>> addGroceryToCart(int cartId,int groceryId,int groceryQuantity){
		ResponseStructure<Cart> structure= new ResponseStructure<>();
		Cart cart = dao.addGroceryToCart(groceryId, cartId,groceryQuantity);
		if(cart!=null) {
			structure.setData(cart);
			structure.setMessage("grocery added to cart");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Cart>>(structure,HttpStatus.FOUND);
		}
		else {
			structure.setMessage("cart or grocery not found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Cart>>(structure,HttpStatus.NOT_FOUND);
		}
	}
	public ResponseEntity<ResponseStructure<Cart>> addProcesseddGoodToCart(int cartId, int processedGoodId){
		ResponseStructure<Cart> structure = new ResponseStructure<>();
		Cart cart = dao.addProcessedGoodsToCart(processedGoodId, cartId);
		if(cart!=null){
			structure.setData(cart);
			structure.setMessage("processed goods added");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Cart>>(structure,HttpStatus.FOUND);
		}
		else {
			structure.setMessage("cart or processed god not found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Cart>>(structure,HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Cart>> deleteGroceryByName(int cartId, String groceryName){
		ResponseStructure<Cart> structure = new ResponseStructure<>();
		Cart cart = dao.deleteGroceryByName(cartId, groceryName);
		if(cart!=null) {
			structure.setData(cart);
			structure.setMessage("grocery found and deleted from cart success");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Cart>>(structure,HttpStatus.OK);
		}else {
			structure.setMessage("cart or grocery not found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Cart>>(structure,HttpStatus.NOT_FOUND);
		}
	}
	public ResponseEntity<ResponseStructure<Cart>> deleteProcessedGoodByName(int cartId, String processedGoodName){
		ResponseStructure<Cart> structure = new ResponseStructure<>();
		Cart cart = dao.deleteProcessedGoodByName(cartId, processedGoodName);
		if(cart!=null) {
			structure.setData(cart);
			structure.setMessage("processed good found and deleted from cart success");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Cart>>(structure,HttpStatus.OK);
		}else {
			structure.setMessage("cart or good not found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Cart>>(structure,HttpStatus.NOT_FOUND);
		}
	}
	

}
