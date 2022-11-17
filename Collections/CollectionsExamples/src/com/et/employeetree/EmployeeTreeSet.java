package com.et.employeetree;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class EmployeeTreeSet {
	
	public static void main(String args[]) {
		/*
		 * TreeSet : unique sorted collection of values, which is auto-growable and auto-shrinkable 
		 */
		Set<Employee> myEmployees = new TreeSet<Employee>();
		
		myEmployees.add(new Employee(101, "James", 1, "Junior", "Software", 35000));
		myEmployees.add(new Employee(102, "Susan", 10, "Head of department", "Software", 90000));
		myEmployees.add(new Employee(103, "Ella", 6, "Senior", "Software", 60000));
		myEmployees.add(new Employee(104, "Arthur", 3, "Junior", "Software", 40000));
		myEmployees.add(new Employee(105, "Bill", 8, "Manager", "Software", 75000));
		myEmployees.add(new Employee(106, "Joe", 7, "Senior", "Software", 62500));
		
		System.out.println("===== Here are your employees =====");

		Iterator<Employee> iterator = myEmployees.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
