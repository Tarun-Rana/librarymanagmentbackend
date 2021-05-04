package com.cognizant.Library.Managment.Service;

import java.util.Set;

import com.cognizant.Library.Managment.model.CartItems;

public interface CartItemService {

	public Set<CartItems> getAllCartItems(String userName);
	
	public void addToCartItem(String userName,long bookId);
	
	public void removeCartItem(String userName,long bookId);
}
