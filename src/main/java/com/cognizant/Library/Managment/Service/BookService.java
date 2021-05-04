package com.cognizant.Library.Managment.Service;

import com.cognizant.Library.Managment.model.Book;

public interface BookService {
	
	public Book findBookById(long bookId);
	
	public boolean addBook(Book book);
}
