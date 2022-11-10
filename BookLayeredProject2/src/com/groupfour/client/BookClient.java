package com.groupfour.client;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.groupfour.presentation.BookPresentation;

public class BookClient {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
//		EmployeePresentation employeePresentation=new EmployeePresentationImpl();
		ApplicationContext springContainer = new ClassPathXmlApplicationContext("bookconfiguration.xml");
		BookPresentation bookPresentation=(BookPresentation)springContainer.getBean("presentation");
		
		while(true) {
			bookPresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			bookPresentation.performMenu(choice);
		}
	}
}
