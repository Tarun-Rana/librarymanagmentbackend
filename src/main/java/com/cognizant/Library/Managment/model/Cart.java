package com.cognizant.Library.Managment.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cart_id")
	private long cartId;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="ct_us_id")
	private User user;
	
	@JsonIgnore
	@OneToMany(mappedBy="cart",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Set<CartItems> cartItem;
	
	
	
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(long cartId, User user, Set<CartItems> cartItem) {
		super();
		this.cartId = cartId;
		this.user = user;
		this.cartItem = cartItem;
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<CartItems> getCartItem() {
		return cartItem;
	}

	public void setCartItem(Set<CartItems> cartItem) {
		this.cartItem = cartItem;
	}


	
	
}
