package com.groupfour.service;

import java.util.Collection;

import com.groupfour.entity.Book;
import com.groupfour.persistence.BookDao;
import com.groupfour.persistence.BookDaoImpl;

import lombok.Setter;

public class BookServiceImpl implements BookService {
	
	@Setter
	private BookDao bookdao;
	
	private BookDao bookDao = new BookDaoImpl();

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
		if(bookDao.addBook(book) > 0) {
			return true;
		} 
		return false;
	}

	@Override
	public boolean deleteBook(int id) {
		if(bookDao.deleteBook(id) > 0) {
			return true;
		}
		return false;
	}
}
