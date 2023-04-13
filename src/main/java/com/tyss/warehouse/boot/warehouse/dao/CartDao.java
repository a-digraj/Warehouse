package com.tyss.warehouse.boot.warehouse.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.warehouse.boot.warehouse.entity.Cart;
import com.tyss.warehouse.boot.warehouse.entity.Grocery;
import com.tyss.warehouse.boot.warehouse.entity.ProcessedGood;
import com.tyss.warehouse.boot.warehouse.repo.CartRepo;
import com.tyss.warehouse.boot.warehouse.repo.GroceryRepo;
import com.tyss.warehouse.boot.warehouse.repo.ProcessedGoodRepo;

@Repository
public class CartDao {
	@Autowired
	private CartRepo repo;
	@Autowired
	private GroceryRepo groceryRepo;
	@Autowired
	private ProcessedGoodRepo processedGoodRepo;

	public Cart addCart(Cart cart) {
		return repo.save(cart);
	}

	public Cart updateCart(Cart cart, int cartId) {
		Optional<Cart> cart2 = repo.findById(cartId);
		if (cart2.isPresent()) {
			cart.setCartId(cartId);
			return repo.save(cart);
		}
		return null;
	}

	public Cart findCartById(int cartId) {
		Optional<Cart> cart2 = repo.findById(cartId);
		if (cart2.isPresent()) {
			return cart2.get();
		}
		return null;
	}

	public Cart deleteCartById(int cartId) {
		Optional<Cart> cart2 = repo.findById(cartId);
		if (cart2.isPresent()) {
			repo.delete(cart2.get());
			return cart2.get();
		}
		return null;
	}
	
//	
//	public Cart deleteCardtById(int cartId) {
//		
//	}

	public Cart addGroceryToCart(int groceryid, int cartId) {
		Optional<Cart> cart = repo.findById(cartId);
		Optional<Grocery> grocery = groceryRepo.findById(groceryid);
		
//		if(cart.isPresent() && grocery.isPresent()) {
//			System.out.println(cart.get() +"  "+ grocery.get());
//			cart.get().getGroceries().add(grocery.get());
//			return updateCart(cart.get(), cartId);
//		}
		
		if (cart.isPresent() && grocery.isPresent()) {
			Cart cart2 = cart.get();
			Grocery grocery2 = grocery.get();
			if (cart2.getGroceries() != null) {
				cart2.getGroceries().add(grocery2);
			} else {
				List<Grocery> groceries = Arrays.asList(grocery2);
				cart2.setGroceries(groceries);
			}
			return updateCart(cart2, cartId);
		}

		 else
			return null;
	}

	public Cart addProcessedGoodsToCart(int processedGoodId, int cartId) {
		Optional<Cart> cart = repo.findById(cartId);
		Optional<ProcessedGood> processedGood = processedGoodRepo.findById(processedGoodId);
		if (cart.isPresent() && processedGood.isPresent()) {
			Cart cart2 = cart.get();
			ProcessedGood good = processedGood.get();
			if(cart2.getProcessedGoods() != null) {
				cart2.getProcessedGoods().add(good);
			}else {
				List<ProcessedGood> pgoods = Arrays.asList(good);
				cart2.setProcessedGoods(pgoods);
			}
			return updateCart(cart2, cartId);
		} else
			return null;
	}
}