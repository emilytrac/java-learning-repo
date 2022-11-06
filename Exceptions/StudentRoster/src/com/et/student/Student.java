package com.et.student;

import com.et.exception.AgeException;
import com.et.exception.MarkException;

public class Student {
	
	private int rollNo, age, marks;
	private String name;
	
	public Student(int rollNo, String name, int age, int marks) throws MarkException, AgeException {
		if ((age >= 4 && age <= 18) && (marks >= 0 && marks <= 100)) {
			this.rollNo = rollNo;
			this.name = name;
			this.age = age;
			this.marks = marks;
		} else if (age < 4 || age > 18) {
			throw new AgeException("Age must be between 4 and 18");
		} else if (marks < 0 || marks > 100) {
			throw new MarkException("Mark must be between 0 and 100");
		}

	}
	
	public int getRollNo() {
		return rollNo;
	}
	
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) throws AgeException {
        if (age >= 18 && age <= 60) {
            this.age = age;
        }
        else 
        	throw new AgeException("Age must be between 4 and 18"); 
	}
	
	public int getMarks() {
		return marks;
	}
	
	public void setMarks(int marks) throws MarkException {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        }
        else 
        	throw new MarkException("Age must be between 4 and 18"); 
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
