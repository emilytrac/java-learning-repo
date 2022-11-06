package com.et.student;

import java.util.Scanner;

import com.et.exception.AgeException;
import com.et.exception.MarkException;
import com.et.exception.RollNoException;

public class StudentRoster {
	
	public static void main(String[] args) {
		
        // instantiate scanner
        Scanner scanner = new Scanner(System.in);
        
        // try catch block for exceptions
        try {
        	
        	System.out.println("Please enter number of students: ");
 	        int total = scanner.nextInt();
 	        
 	        StudentInput studentInput = new StudentInput(total);
 	        
	 	        for (int index = 0; index < total; index++) {
	
		        	System.out.println("====== Adding a Student ======");
			           
				    System.out.println("Please enter student roll number: ");
			        int rollNo = scanner.nextInt();
			        System.out.println("Please enter student name: ");
			        String name = scanner.next();
			        System.out.println("Please enter student age: ");
			        int age = scanner.nextInt();
			        System.out.println("Please enter student marks: ");
			        int marks = scanner.nextInt();
			
			        Student student = new Student(rollNo, name, age, marks);
			
			        studentInput.inputStudent(student, index);
	            
	 	        }
            studentInput.displayStudent(); 
		}	 
        // propagate known exception
        catch (RollNoException exception) { 
            System.out.println(exception.getMessage());
        }
        // propagate known exception
        catch(AgeException exception) {
            System.out.println(exception.getMessage());
        }
        // propagate known exception
        catch(MarkException exception) {
        	System.out.println(exception.getMessage());
        }
        //general exception for unexpected exceptions (unchecked)
        catch(Exception exception) {
			System.out.println("Something went wrong, please try again");
		}
        finally {
        	scanner.close();
        } 
	}
}
