package com.emily.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emily.entity.Book;
import com.emily.persistence.BookDao;

@Component("service")
public class BookServiceImpl implements BookService {
	
	private BookDao bookDao;

	public BookServiceImpl(@Autowired BookDao bookDao) {
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

	@Override
	public boolean updateBook(int id, int increment) {
		if(bookDao.updateBook(id,increment)>0)
			return true;
		return false;
	}
}
