package com.groupfour.service;

import java.util.Collection;

import com.groupfour.entity.Book;

public interface BookService {
	
	Collection<Book> getAllBooks();
	
	Book searchBookById(int id);
	
	boolean addNewBook(Book book);

}
