package com.techmahindra.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techmahindra.model.Employee;
import com.techmahindra.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getEmployeeDetails(@PathVariable(value = "id") int id){
		Employee emp=empService.getEmployeeDetails(id);
		return new ResponseEntity<>(emp,HttpStatus.OK);
		
	}
	
	@PostMapping("/save/employee")
	public ResponseEntity<?> saveEmployeeDetails(@RequestBody Employee employee){
		Employee emp=empService.saveEmployeeDetails(employee);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateEmployeeDetailsById(@PathParam(value = "id") int id){
		Employee updatedEmp=empService.updateEmployeeDetailsById(id);
		return new ResponseEntity<>(updatedEmp,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployeeDetailsById(@PathParam(value = "id") int id){
		return empService.deleteEmployeeDetailsById(id);

	}

}
