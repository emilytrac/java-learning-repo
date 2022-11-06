package com.et.employee;

import com.et.exception.NameCheckedException;

public class EmployeeList {
    
    // instance variables of class
    private Employee[] employees;
    private int totalNumEmployees; 
    
    // constructor
    public EmployeeList(int totalNumEmployees) {
        this.totalNumEmployees = totalNumEmployees;
        employees = new Employee[this.totalNumEmployees]; // makes array of employeeInput class objects
      
    }
    
    // method for inputting an employees info into the employee list
    public void inputEmployeeName(Employee employee, int index) throws NameCheckedException {
        for (int i = 0; i < index; i++) {
        	if (employees[i].getName().equals(employee.getName())) {
        		throw new NameCheckedException("Name already exists");
        	}
        }
    }    
    
    // for each employee in employees, display info
    public void displayList() {
        for (Employee employee : employees) {
            employee.display();
        }      
    }  
}