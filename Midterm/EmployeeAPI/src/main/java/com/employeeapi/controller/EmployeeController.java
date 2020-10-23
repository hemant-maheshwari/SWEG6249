package com.employeeapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeeapi.model.Employee;
import com.employeeapi.service.EmployeeService;

@RestController
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("api/v1/employees")
	public ArrayList<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@PostMapping("api/v1/employees")
	public Employee create(@RequestBody Employee employee) {
		return employeeService.create(employee);
	}
	
	@PutMapping("api/v1/employees/{id}")
	public void update(@PathVariable("id") Integer id, @RequestBody Employee employee) {
		employeeService.update(id, employee);
	}
	
	@GetMapping("api/v1/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		employeeService.delete(id);
	}
	
}
