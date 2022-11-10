package com.groupfour.database;

import java.util.LinkedHashMap;
import java.util.Map;

import com.groupfour.entity.Book;

public class BookDatabase {

	static private Map<Integer, Book> bookList = new LinkedHashMap<Integer, Book>();
	
	static {
		bookList.put(1, new Book(1, "Harry Potter", "JK Rowling", 20));
		bookList.put(2, new Book(2, "Hunger Games", "Susanne Collins", 15));
		bookList.put(3, new Book(3, "Me Before You", "Jojo Mayers", 22));
		bookList.put(4, new Book(4, "Divergent", "Veronica Roth", 18));
		bookList.put(5, new Book(5, "Twilight", "Stephanie Meyer", 19));
	}

	public static Map<Integer, Book> getBookList() {
		return bookList;
	}
}
