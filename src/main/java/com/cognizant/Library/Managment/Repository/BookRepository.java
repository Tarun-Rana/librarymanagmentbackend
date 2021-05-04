package com.cognizant.Library.Managment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.Library.Managment.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	public Book findByBookId(long bookId);
}
