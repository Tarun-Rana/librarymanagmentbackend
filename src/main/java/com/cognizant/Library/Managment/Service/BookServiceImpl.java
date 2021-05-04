package com.cognizant.Library.Managment.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Library.Managment.Repository.BookRepository;
import com.cognizant.Library.Managment.model.Book;
import com.cognizant.Library.Managment.model.CartItems;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookReposaitory;
	
	@Autowired
	CartItemServiceImpl cartItemServiceImpl;
	
	int flag = 0;
	
	Set<CartItems> cartItemList = new HashSet<CartItems>();
	
	@Override
	public Book findBookById(long bookId) {
		// TODO Auto-generated method stub
		System.out.println("ad"+bookId);
		return bookReposaitory.findByBookId(bookId);
	}
	
	public List<Book> findAllBooks(){
		
		return bookReposaitory.findAll();
	}
	
	public List<Book> filteredBooks(String username){
		
		List<Book> bookItemList = new ArrayList<Book>();
	
		try{
			System.out.println("in try ");
		cartItemList = cartItemServiceImpl.getAllCartItems(username);
		
		}
		catch(Exception e){
			System.out.println(cartItemList.size() + "size");
			System.out.println("in actch ");
			return findAllBooks();
		}
		
		if(!cartItemList.isEmpty() || cartItemList.size() != 0 || cartItemList!=null){
			List<Book> bookList = findAllBooks();
			System.out.println(cartItemList.toString());
			System.out.println(cartItemList.size() +" size");
			bookList.forEach(book->{
				flag = 0;
				
				
				cartItemList.forEach(cartBook->{
				
					if(cartBook.getBook().getBookName() == book.getBookName()){
						flag = 1;
						
					}
				});
			
				if(flag==0){
					
					bookItemList.add(book);
					System.out.println("added");
				}
				
			});
			
			return bookItemList;
		}
		
		return null;
	}

	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		try{
			bookReposaitory.save(book);
			return true;
		}
		catch(Exception e){
			return false;
		}
		
	}

}
