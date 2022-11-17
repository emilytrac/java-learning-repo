package com.et.linkedhash;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class LinkedHashMain {
	
	public static void main(String[] args) {

		Set<Number> numbersIn = new LinkedHashSet<Number>();
		
		Scanner scanner = new Scanner(System.in);
	
		for (int i = 0; i < 10; i++) {
		
			System.out.println("What number would you like to put in? ");
			
			Number number = new Number(scanner.nextInt(), i);
			int flag = 0;
			
			for(Number element : numbersIn) {
				
				if (element.getNumberIn() == number.getNumberIn()) {
					flag = 1;
					System.out.println("Number already entered! Try a different one!");
					i--;
				}
			}	
			if (flag != 1) {
				numbersIn.add(number);
				System.out.println("Number added successfully!");
			}
		}	
		
		for(Number element : numbersIn) {
			System.out.println(element);
		}	
	}	
}
