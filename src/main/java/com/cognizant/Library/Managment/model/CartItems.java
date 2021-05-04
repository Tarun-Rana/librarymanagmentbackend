package com.cognizant.Library.Managment.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cartitem")
public class CartItems {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ct_it_id")
	private long cartItemId;
	
	/*@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name="cartItem_book",joinColumns = @JoinColumn(name="ct_ct_it_bk_id"),inverseJoinColumns=@JoinColumn(name="bk_ct_it_id"))
	List<Book> bookList;
	*/
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="ct_it_bk")
	private Book book;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="ct_it_cart_id")
	private Cart cart;

	public CartItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public long getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(long cartItemId) {
		this.cartItemId = cartItemId;
	}

	

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	@Override
	public String toString() {
		return "CartItems [cartItemId=" + cartItemId + ", book=" + book + ", cart=" + cart + "]";
	}
	
	
	
}
