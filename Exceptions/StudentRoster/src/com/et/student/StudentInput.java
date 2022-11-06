package com.et.student;

import com.et.exception.RollNoException;

public class StudentInput {
	
	private Student[] students;

	public StudentInput(int totalNumStudents) {
        students = new Student[totalNumStudents]; // makes array for student objects
	}
	
	// input student unless roll number already exists
	public void inputStudent(Student student, int index) throws RollNoException {
        for (int i = 0; i < index; i++) {
        	if (students[i].getRollNo() == student.getRollNo()) 
        		throw new RollNoException("Roll number already exists");
        }
        students[index] = student;
    } 
	
	public void displayStudent() {
		// for each student in list, display
		for (Student student : students) {
			System.out.println("===== Student " + student.getRollNo() + " =====");
			System.out.println("Name: " + student.getName());
			System.out.println("Age: " + student.getAge());
			System.out.println("Marks: " + student.getMarks());
			
		}
		
	}
}
