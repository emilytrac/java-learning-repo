package com.emily.controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.emily.entity.Employee;
import com.emily.entity.EmployeePaySlip;
import com.emily.model.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/")
	public ModelAndView menuPageController() {
		return new ModelAndView("index");
	}
	//=============================================================
	
	//===== Controllers for Delete=================================
	@RequestMapping("/deleteEmpPage")
	public ModelAndView deletePageController() {
		return new ModelAndView("InputIdForDelete");
	}

	@RequestMapping("/deleteEmployee")
	public ModelAndView deleteEmployeeController(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		int eId=Integer.parseInt(request.getParameter("empId"));
		String message=null;
		
		if(employeeService.deleteEmployee(eId))
			message="Employee Deleted with ID "+eId;
		else
			message="Employee with ID "+eId+" does not exist";
		
		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		
		return modelAndView;
	}
	//==============================================================
	
	//=============Controllers for increment Salary==================
	@RequestMapping("/incrementSalaryPage")
	public ModelAndView incrementSalaryPageController() {
		return new ModelAndView("InputIdForIncrement");
	}
	
	
	@RequestMapping("/incrementSalary")
	public ModelAndView incrementSalary(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		int eId=Integer.parseInt(request.getParameter("empId"));
		double increment=Double.parseDouble(request.getParameter("increment"));
		String message=null;
		
		if(employeeService.incrementSalary(eId, increment))
			message="Employee with ID "+eId+" salary incremented with amount "+increment;
		else
			message="Employee with ID "+eId+" does not exist";
		
		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		
		return modelAndView;
	}
	//==============================================================
	
	//=============Controller for List all Employees==================
	@RequestMapping("/showAll")
	public ModelAndView getAllEmployeesController() {
		ModelAndView modelAndView=new ModelAndView();
		Collection<Employee> empList=employeeService.getAllEmployees();
		
		modelAndView.addObject("employees", empList);
		modelAndView.setViewName("ShowAllEmployees");
		
		return modelAndView;
	}
	//===================================================================
	
	//=============Controllers for Search Employee By ID==================
	@RequestMapping("/searchEmployeeByIDInputPage")
	public ModelAndView searchEmployeeByIDInputPageController() {
		return new ModelAndView("InputIdForSearch");
	}

	@RequestMapping("/searchEmployeeByID")
	public ModelAndView searchEmployeeById(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		int id=Integer.parseInt(request.getParameter("empId"));
		
		Employee employee=employeeService.searchEmployeeById(id);
		if(employee!=null) {
			modelAndView.addObject("employee", employee);
			modelAndView.setViewName("ShowEmployee");
		}
		else {
			modelAndView.addObject("message", "Employee with ID "+id+" does not exist");
			modelAndView.setViewName("Output");
		}
		
		return modelAndView;
	}
	//=============================================================
	
	//=============Controllers for Search Employee By Department Name==================
	@RequestMapping("/searchEmployeeByDepartmentInputPage")
	public ModelAndView searchEmployeeByDepartmentInputPageController() {
		return new ModelAndView("InputDepartmentForSearch");
	}
	
	@RequestMapping("/searchEmployeeByDepartment")
	public ModelAndView searchEmployeeByDepartmentController(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		String deptt=request.getParameter("department");
		List<Employee> empList=employeeService.getEmployeesByDepartment(deptt);
		
		if(empList.size()>0) {
			modelAndView.addObject("employees", empList);
			modelAndView.setViewName("ShowAllEmployees");
		}else {
			modelAndView.setViewName("Output");
			modelAndView.addObject("message", "No Employee works in department "+deptt);
		}
		
		return modelAndView;
	}
	//============================================================
	
	//=============Controllers for Add a new employee==================
	@RequestMapping("/addNewEmployeePage")
	public ModelAndView addNewEmployeePageController() {
		return new ModelAndView("AddNewEmployee");
	}
	
	@RequestMapping("/addANewEmployee")
	public ModelAndView addNewEmployeeController(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		Employee newEmployee = new Employee();
		
		int id=Integer.parseInt(request.getParameter("empId"));
		String name=request.getParameter("empName");
		String des=request.getParameter("empDesignation");
		String deptt=request.getParameter("empDepartment");
		double salary=Double.parseDouble(request.getParameter("empSalary"));
		LocalDate doj=LocalDate.parse(request.getParameter("empDoj"));
		String message=null;
		
		newEmployee.setEmpId(id);
		newEmployee.setEmpName(name);
		newEmployee.setEmpDesignation(des);
		newEmployee.setEmpDepartment(deptt);
		newEmployee.setEmpSalary(salary);
		newEmployee.setDateOfJoining(doj);
		
		if (employeeService.addEmployee(newEmployee)) {
			message="Employee with ID "+id+" added";
		} else {
			message="Employee with ID "+id+"already exists";
		}
		
		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		
		return modelAndView;
	}
	//=============================================================
	
	//=============Controllers for Search Employee By Designation Name==================
	@RequestMapping("/searchEmployeeByDesignationInputPage")
	public ModelAndView searchEmployeeByDesignationInputPageController() {
		return new ModelAndView("InputDesignationForSearch");
	}
	
	@RequestMapping("/searchEmployeeByDesignation")
	public ModelAndView searchEmployeeByDesignationController(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		String des=request.getParameter("designation");
		List<Employee> empList=employeeService.searchByDesignation(des);
		
		if(empList.size()>0) {
			modelAndView.addObject("employees", empList);
			modelAndView.setViewName("ShowAllEmployees");
		}else {
			modelAndView.setViewName("Output");
			modelAndView.addObject("message", "No Employee works as a "+des);
		}
		
		return modelAndView;
	}
	//============================================================
	
	//=============Controllers for Generating PaySlip==================
	@RequestMapping("/generatePayslipPage")
	public ModelAndView searchIdForPaySlipController() {
		return new ModelAndView("InputIdForPayslip");
	}
	
	@RequestMapping("/generatePayslip")
	public ModelAndView generateEmployeePayslipController(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		int id=Integer.parseInt(request.getParameter("empId"));
		EmployeePaySlip payslip = employeeService.generatePaySlip(id);
		
		if(payslip!=null) {
			modelAndView.addObject("employeePayslip", payslip);
			modelAndView.setViewName("ShowPayslip");
		}else {
			modelAndView.setViewName("Output");
			modelAndView.addObject("message", "Employee with ID "+id+" does not exist");
		}
		
		return modelAndView;
	}
	//============================================================
	
	//=============Controllers for Deleting by name==================
	@RequestMapping("/searchEmployeeByNameInputPage")
	public ModelAndView findNameForDeletionController() {
		return new ModelAndView("InputNameForDelete");
	}
	
	@RequestMapping("/searchEmployeeByName")
	public ModelAndView deleteEmployeeByNameController(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		String name=request.getParameter("empName");
		String message=null;
		
		if(employeeService.deleteEmployeeByName(name)) {
			message="Employee with name "+name+" deleted";
		} else {
			message="Employee with name "+name+" doesn't exist";
		}
		
		modelAndView.addObject("message", message);
		modelAndView.setViewName("Output");
		
		return modelAndView;
	}
}
