package com.cognizant.Library.Managment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="us_id")
	private long userId;
	
	@Column(name="us_email")
	private String email;
	
	@Column(name="us_name")
	private String name;
	
	@Column(name="us_contact_number")
	private long contactNumber;
	
	@Column(name="us_role")
	private String role;
	
	@Column(name="us_password")
	private String password;
	
	@JsonIgnore
	@OneToOne(mappedBy="user")
	private Cart cart;

	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public User(long userId, String email, String name, String password, long contactNumber, String role) {
		super();
		this.userId = userId;
		this.email = email;
		this.name = name;
		this.contactNumber = contactNumber;
		this.role = role;
		this.password = password;
	}
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	public Cart getCart() {
		return cart;
	}



	public void setCart(Cart cart) {
		this.cart = cart;
	}

	
	
}
