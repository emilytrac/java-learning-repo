package com.groupfour.client;

import java.util.Scanner;

import com.groupfour.presentation.BookPresentation;
import com.groupfour.presentation.BookPresentationImpl;

public class BookClient {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		BookPresentation bookPresentation = new BookPresentationImpl();

		while(true) {
			bookPresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			bookPresentation.performMenu(choice);
		}
	}
}
