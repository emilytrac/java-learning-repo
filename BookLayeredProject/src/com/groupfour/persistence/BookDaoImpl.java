package com.groupfour.persistence;

import java.util.Collection;

import com.groupfour.database.BookDatabase;
import com.groupfour.entity.Book;

public class BookDaoImpl implements BookDao {

	@Override
	public Collection<Book> getAllBooks() {
		return BookDatabase.getBookList().values();
	}

	@Override
	public Book searchBook(int id) {
		return BookDatabase.getBookList().get(id);
	}

	@Override
	public Book addBook(Book book) {
		return BookDatabase.getBookList().put(book.getBookId(), book);
	}
}
