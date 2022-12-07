package com.emily.service;

import java.util.Collection;

import com.emily.entity.Book;

public interface BookService {
	
	Collection<Book> getAllBooks();
	
	Book searchBookById(int id);
	
	boolean addNewBook(Book book);
	
	boolean deleteBook(int id);

	boolean updateBook(int id, int increment);
}
