package com.et.employee;

import java.util.Scanner;

import com.et.exception.AgeCheckedException;
import com.et.exception.NameCheckedException;

public class EmployeeMain {
    
    
    public static void main(String[] args) {
        // instantiate scanner
        Scanner scanner = new Scanner(System.in);
        
        // try catch block for exceptions
        try {
	        System.out.println("Please enter number of employees: ");
	        int total = scanner.nextInt();
	
	        EmployeeList employeeList = new EmployeeList(total);
       
            for (int i = 0; i < total; i++) { // for all indices of employeeList

            	System.out.println("Please enter employee name: ");
                String name = scanner.next();
                
            	System.out.println("Please enter employee age: ");
                int age = scanner.nextInt();

                Employee employee = new Employee(name, age);

                employeeList.inputEmployeeName(employee, i);
            }
            employeeList.displayList();  
        } 
        // propagate exception
        catch (AgeCheckedException exception) { 
            System.out.println(exception.getMessage());
        }
        // propagate exception
        catch(NameCheckedException exception) {
            System.out.println(exception.getMessage());
        }
        // negative number exception
        catch(NegativeArraySizeException exception) {
        	System.out.println("The total number of employees must be positive");
        }
        // general exception
        catch(Exception exception) {
			System.out.println("Something went wrong, please try again");
		}
        finally {
        	scanner.close();
        }
    }   
}

