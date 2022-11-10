package com.groupfour.persistence;

import java.util.Collection;

import com.groupfour.entity.Book;

public interface BookDao {

	Collection<Book> getAllBooks();
	Book searchBook(int id);
	Book addBook(Book book);
}
