package com.cognizant.Library.Managment.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Library.Managment.Repository.BookRepository;
import com.cognizant.Library.Managment.Repository.CartItemRepository;
import com.cognizant.Library.Managment.Repository.CartRepository;
import com.cognizant.Library.Managment.Repository.UserRepository;
import com.cognizant.Library.Managment.model.Book;
import com.cognizant.Library.Managment.model.Cart;
import com.cognizant.Library.Managment.model.CartItems;
import com.cognizant.Library.Managment.model.User;

@Service
public class CartItemServiceImpl implements CartItemService{
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CartItemRepository cartItemRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	CartItems cartItems;
	CartItems cartIt = new CartItems();
	
	
	List<CartItems> userCartItems;
	
	@Override
	public Set<CartItems> getAllCartItems(String userName) {
		// TODO Auto-generated method stub
		User user =  userRepository.findByEmail(userName);
		System.out.println( user.getCart().getCartItem());
		return user.getCart().getCartItem();
		
	}
	
	
	
	
	@Override
	public void addToCartItem(String userName, long bookId) {
		
		
		Book book = bookRepository.findByBookId(bookId);
		User user = userRepository.findByEmail(userName);

		Cart userCart = user.getCart();
		System.out.println(userCart);
		if(userCart == null){
			System.out.println(userCart+"sds");
			userCart=new Cart();
			userCart.setUser(user);
			user.setCart(userCart);
		}
		Set<CartItems> cartItemList=userCart.getCartItem();
		if(cartItemList == null){
			cartItemList = new HashSet<CartItems>();
		}
		CartItems cartItems = new CartItems();
		cartItems.setBook(book);
		cartItems.setCart(userCart);
		System.out.println(cartItems);
		cartItemList.add(cartItems);
		userCart.setCartItem(cartItemList);
		
//		cartItemRepository.save(cartItems);
		cartRepository.save(userCart);
		
		
	}

	@Override
	public void removeCartItem(String userName, long bookId) {
		// TODO Auto-generated method stub
		System.out.println(userName);
		System.out.println(bookId);
		
		Book book = bookRepository.findByBookId(bookId);
		User user = userRepository.findByEmail(userName);
		System.out.println(book.toString());
		System.out.println(user.toString());
		System.out.println(user.getCart().getCartItem().size());
		user.getCart().getCartItem().forEach(books->{
			if(books.getBook().getBookId() == book.getBookId()){
				cartIt = books;
				
				
			}
			
		
		});
		
		user.getCart().getCartItem().remove(cartIt);
		cartItemRepository.delete(cartIt);
		cartRepository.save(user.getCart());
		
	}
	
	

}
