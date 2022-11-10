package com.groupfour.service;

import java.util.Collection;

import com.groupfour.entity.Book;
import com.groupfour.persistence.BookDao;

public class BookServiceImpl implements BookService {
	
	private BookDao bookDao;

	public BookServiceImpl(BookDao bookDao) {
		super();
		this.bookDao = bookDao;
	}

	@Override
	public Collection<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	@Override
	public Book searchBookById(int id) {
		return bookDao.searchBook(id);
	}

	@Override
	public boolean addNewBook(Book book) {
		Book bookToAdd = bookDao.searchBook(book.getBookId());
		if (bookToAdd != null) {
			return false;
		}
		bookDao.addBook(book);
		return true;
	}
}
