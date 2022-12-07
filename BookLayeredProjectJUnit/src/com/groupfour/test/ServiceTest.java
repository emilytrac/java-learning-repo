package com.groupfour.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.groupfour.entity.Book;
import com.groupfour.persistence.BookDao;
import com.groupfour.service.BookServiceImpl;

class ServiceTest {
	
	private BookServiceImpl bookServiceImpl;
	private BookDao bookDao;

	@BeforeEach
	void setUp() throws Exception {
		bookServiceImpl = new BookServiceImpl();
		
		bookDao = Mockito.mock(BookDao.class);
		bookServiceImpl.setBookdao(bookDao);
	}

	@AfterEach
	void tearDown() throws Exception {
	}


	@Test
	void testAddNewBookOne() {
		when(bookDao.addBook(new Book(5, "Twilight", "Stephanie Meyer", 19))).thenReturn(1);
		
		assertTrue(bookServiceImpl.addNewBook(new Book(5, "Twilight", "Stephanie Meyer", 19)));
	}
	
	@Test
	void testAddNewBookTwo() {
		when(bookDao.addBook(new Book(5, "Twilight", "Stephanie Meyer", 19))).thenReturn(0);
		
		assertFalse(bookServiceImpl.addNewBook(new Book(5, "Twilight", "Stephanie Meyer", 19)));
	}

	@Test
	void testDeleteBookOne() {
		when(bookDao.deleteBook(5)).thenReturn(1);
		
		assertTrue(bookServiceImpl.deleteBook(5));
	}
	
	@Test
	void testDeleteBookTwo() {
		when(bookDao.deleteBook(5)).thenReturn(0);
		
		assertFalse(bookServiceImpl.deleteBook(5));
	}

}
