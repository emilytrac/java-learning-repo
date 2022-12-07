package com.emily.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.emily.entity.Book;
import com.emily.persistence.BookDaoImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class BookSpringBootTestApplicationTests {

	@Autowired
	BookDaoImpl bookDaoImpl;

	@DisplayName("Check Get All Books")
	@Order(1)
	@Test
	void TOO1() {
		assertTrue(bookDaoImpl.getAllBooks().size() > 0);
	}
	
	@DisplayName("Search for Book with id 6")
	@Order(3)
	@Test
	void TO02() {
		Book book = new Book(6, "To Kill a Mockingbird", "Harper Lee", 43);
		assertEquals(book, bookDaoImpl.searchBook(6));
	}
	
	@DisplayName("Search for book that doesn't exist")
	@Order(4)
	@Test
	void TO03() {
		assertNull(bookDaoImpl.searchBook(10));
	}
	
	@DisplayName("Add new book with id 6")
	@Order(2)
	@Test
	void TOO4() {
		assertEquals(1, bookDaoImpl.addBook(new Book(6, "To Kill a Mockingbird", "Harper Lee", 43)));
	}
	
	@DisplayName("Delete book that doesn't exist")
	@Order(6)
	@Test 
	void T006(){
		assertEquals(0, bookDaoImpl.deleteBook(10));
	}
	
	@DisplayName("Delete book with id 6")
	@Order(5)
	@Test
	void T005() {
		assertEquals(1, bookDaoImpl.deleteBook(6));
	}

}
