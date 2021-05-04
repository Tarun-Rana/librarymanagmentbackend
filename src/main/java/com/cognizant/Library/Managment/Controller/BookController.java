package com.cognizant.Library.Managment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Library.Managment.Service.BookServiceImpl;
import com.cognizant.Library.Managment.model.Book;

@RestController
@RequestMapping("book")
public class BookController {
	
	@Autowired
	BookServiceImpl bookServiceImpl;
	
	@GetMapping
	public List<Book> findAllBooks(){
		return bookServiceImpl.findAllBooks();
	}
	
	@GetMapping("/{id}")
	public Book findBookById(@PathVariable long id){
		System.out.println(id+" df");
		return bookServiceImpl.findBookById(id);
	}
	
	@GetMapping("/filter/{username}")
	public List<Book> findFilteredBook(@PathVariable String username){
	
		return bookServiceImpl.filteredBooks(username);
	}
	
	@PostMapping("/add")
	public boolean addBook(@RequestBody Book book){
		System.out.println("in add book "+book.getBookName());
		
		return bookServiceImpl.addBook(book);
	}

}
