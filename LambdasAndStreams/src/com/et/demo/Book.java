package com.et.demo;

public class Book {
	
	private int bookId;
	private String bookName;
	private String authorName;
	private int noOfPages;
	private int price;
	
	public Book() {
		
	// constructor	
	}
	public Book(int bookId, String bookName, String authorName, int noOfPages, int price) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.noOfPages = noOfPages;
		this.price = price;
	}
	
	// getters and setters
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getNoOfPages() {
		return noOfPages;
	}
	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	// custom toString method
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", noOfPages="
				+ noOfPages + ", price=" + price + "]";
	}

}
