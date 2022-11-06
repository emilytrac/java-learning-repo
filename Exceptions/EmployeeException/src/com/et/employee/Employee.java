package com.et.employee;

import com.et.exception.AgeCheckedException;

public class Employee {
    
    // instance variables of class
    private int Age;
    private String Name;
    
    // constructor
    public Employee(String Name, int Age) throws AgeCheckedException {
    	// no exception if age allowed
        if (Age >= 18 && Age <= 60) {
            this.Age = Age; 
            this.Name = Name;
        }
        else // throw the exception
            throw new AgeCheckedException("Age must be between 18 and 60");
    }
    
    // getters and setters 
    public int getAge() {
        return Age;
    }

    // exception handling
    public void setAge(int Age) throws AgeCheckedException {
        if (Age >= 18 && Age <= 60) {
            this.Age = Age;
        }
        else 
        	throw new AgeCheckedException("Age must be between 18 and 60");  
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    // display method to print employees details
    public void display() {
        System.out.println("Name of employee: "+ Name 
        		+ " Age of employee: "+ Age);
        
    }
    
}
