package com.employeeapi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeapi.model.Employee;
import com.employeeapi.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public ArrayList<Employee> getAllEmployees(){
		return (ArrayList<Employee>) employeeRepository.findAll();
	}
	
	public Employee create(Employee employee) {
		employee = employeeRepository.save(employee);
		return employee;
	}
	
	public void update(Integer id, Employee employee) {
		employee.setEmpId(id);
		employeeRepository.save(employee);
	}
	
	public void delete(Integer id) {
		employeeRepository.deleteById(id);
	}

}
