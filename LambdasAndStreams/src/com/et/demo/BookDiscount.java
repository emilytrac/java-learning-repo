package com.et.demo;

public class BookDiscount {
	
	private Book book;
	private double discount;
	
	public BookDiscount() {
	}

	// constructor
	public BookDiscount(Book book, double discount) {
		//super();
		this.book = book;
		this.discount = discount;
	}

	// getters and setters
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	// custom toString method
	@Override
	public String toString() {
		return "BookDiscount [book=" + book + ", discount=" + discount + "]";
	}

}
