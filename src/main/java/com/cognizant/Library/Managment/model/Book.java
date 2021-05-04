package com.cognizant.Library.Managment.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "book",uniqueConstraints=@UniqueConstraint(columnNames="book_name"))
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private long bookId;
	
	@Column(name = "book_image_src")
	private String bookImagesrc;

	
	@Column(name = "book_name")
	private String bookName;

	@Column(name = "book_genre")
	private String bookGenre;

	@Column(name = "book_author_name")
	private String bookAuthorName;

	@Column(name = "book_price")
	private int bookPrice;

	@Column(name = "book_quantity")
	private int bookQuantity;

	/*@ManyToMany(mappedBy="bookList")
	List<CartItems> cartItems;*/
	@JsonIgnore
	@OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="ct_it_bk")
	List<CartItems> cartItems;
	
	
	
	public List<CartItems> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}

	
	public Book(long bookId, String bookImageSrc, String bookName, String bookGenre, String bookAuthorName,
			int bookPrice, int bookQuantity) {
		super();
		this.bookId = bookId;
		this.bookImagesrc = bookImageSrc;
		this.bookName = bookName;
		this.bookGenre = bookGenre;
		this.bookAuthorName = bookAuthorName;
		this.bookPrice = bookPrice;
		this.bookQuantity = bookQuantity;
	}

	public Book() {
		super();

	}

	

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	public String getBookAuthorName() {
		return bookAuthorName;
	}

	public void setBookAuthorName(String bookAuthorName) {
		this.bookAuthorName = bookAuthorName;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getBookQuantity() {
		return bookQuantity;
	}

	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}

	

	public String getBookImagesrc() {
		return bookImagesrc;
	}

	public void setBookImagesrc(String bookImagesrc) {
		this.bookImagesrc = bookImagesrc;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	
	

	

}
