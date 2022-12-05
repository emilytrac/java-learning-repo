package com.emily.model.service;

import java.util.Collection;
import java.util.List;

import com.emily.entity.Employee;
import com.emily.entity.EmployeePaySlip;

public interface EmployeeService {

	Collection<Employee> getAllEmployees();
	
	Employee searchEmployeeById(int id);
	
	boolean addEmployee(Employee employee);
	
	boolean deleteEmployee(int id);
	
	boolean incrementSalary(int id,double increment);
	
	EmployeePaySlip generatePaySlip(int employeeId);
	
	List<Employee> getEmployeesByDepartment(String deptt);
	
	List<Employee> searchByDesignation(String designation);
	
	boolean deleteEmployeeByName(String name);
}
