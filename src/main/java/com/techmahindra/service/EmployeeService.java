package com.techmahindra.service;

import org.springframework.stereotype.Service;

import com.techmahindra.model.Employee;

@Service
public class EmployeeService {
	
	public Employee getEmployeeDetails(int id) {
		Employee emp=new Employee();
		emp.setId(1);
		emp.setName("mani");
		emp.setAddress("Hyderabad");
		emp.setSalary(1000);
		return emp;
	}
	
	public Employee saveEmployeeDetails(Employee e) {
		Employee emp=new Employee();
		emp.setId(2);
		emp.setName(e.getName());
		emp.setSalary(e.getSalary());
		emp.setAddress(e.getAddress());
		return e;
	}
	
	
	public Employee updateEmployeeDetailsById(int id) {
		Employee emp=new Employee();
		emp.setId(id);
		emp.setName("teja");
		emp.setAddress("Hyderabad");
		emp.setSalary(2000);
		return emp;
	}
	
	public String deleteEmployeeDetailsById(int id) {
		return "employee  with Id "+id+" deleted successfully";
	}

}
