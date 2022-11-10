package com.groupfour.presentation;

import java.util.Collection;
import java.util.Scanner;

import com.groupfour.entity.Book;
import com.groupfour.service.BookService;


public class BookPresentationImpl implements BookPresentation {
	
	private BookService bookService;

	public void setBookPresentationImpl(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public void showMenu() {
		System.out.println("1. List all books");
		System.out.println("2. Search by ID");
		System.out.println("3. Add new book");
		System.out.println("4. Exit");
	}

	@Override
	public void performMenu(int menuChoice) {
		Scanner scanner = new Scanner(System.in);
		
		switch(menuChoice) {
		case 1:
			Collection<Book> books = bookService.getAllBooks();
			for(Book book : books) {
				System.out.println(book);
			}
			break;
		case 2:
			System.out.println("Enter book ID : ");
			int id = scanner.nextInt();
			Book book = bookService.searchBookById(id);
			if(book != null)
				System.out.println(book);
			else
				System.out.println("Does not exist");
			break;
		case 3:
			Book newBook = new Book();
			System.out.println("Enter book ID : ");
			newBook.setBookId(scanner.nextInt());
			System.out.println("Enter book name : ");
			newBook.setBookName(scanner.next());
			System.out.println("Enter book author : ");
			newBook.setAuthorName(scanner.next());
			System.out.println("Enter number of copies : ");
			newBook.setNumCopies(scanner.nextInt());
			
			if(bookService.addNewBook(newBook))
				System.out.println("Book added");
			else
				System.out.println("Book already exists");
			break;
		case 4:
			System.out.println("Thanks for using the Book system");
			// exits the system
			System.exit(0);
		default: 
			System.out.println("Not a choice");
			break;
		}
	}

}