package com.employeeapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.employeeapi.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
