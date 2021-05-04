package com.cognizant.Library.Managment.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Library.Managment.Service.CartItemService;
import com.cognizant.Library.Managment.model.CartItems;

@RestController
@RequestMapping("cart")
public class CartController {

	@Autowired
	CartItemService cartItemService;
	
	@GetMapping("/add/{userName}/{bookId}")
	public void addToCartItem(@PathVariable String userName,@PathVariable long bookId){
		System.out.println("sds"+bookId + userName);
		cartItemService.addToCartItem(userName, bookId);
	}
	
	@GetMapping("/{userName}")
	public Set<CartItems> getAllCartItems(@PathVariable String userName){
		return cartItemService.getAllCartItems(userName);
	}
	
	@DeleteMapping("/{userName}/{bookId}")
	public void removeCartItem(@PathVariable String userName,@PathVariable long bookId){
		cartItemService.removeCartItem(userName, bookId);
	}
}
