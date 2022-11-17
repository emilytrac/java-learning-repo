package com.et.employeetree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Employee implements Comparable<Employee> {
	
	private int iD;
	private String name;
	private int experience;
	private String designation;
	private String department;
	private int salary;
	
	/*
	 * TreeSet will be using compareTo() to arrange objects 
	 * in ascending order and will only store unique objects
	 * if object1 (this) is greater return :1
	 * if object2(argument) is greater return : -1
	 * if both objects are equal : 0
	 * Binary Tree sorting!
	 */
	
	@Override
	public int compareTo(Employee o) {
		if(experience>o.experience)
			return 1;
		else if(experience<o.experience)
			return -1;
		else if(this.equals(o))
			return 0;
		return 1;
	}

}
