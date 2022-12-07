package com.emily.persistence;

import java.util.Collection;

import com.emily.entity.Book;

public interface BookDao {

	Collection<Book> getAllBooks();
	
	Book searchBook(int id);
	
	int addBook(Book book);
	
	int  deleteBook(int id);
	
	int updateBook(int id, int increment);
}
