package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepo employeeRepo;

	@GetMapping("employees")
	public List<Employee> getEmployees() {
		return employeeRepo.getEmployees();
	}

	@PostMapping("employee")
	public Employee createEmployee(Employee e) {
		System.out.println(e);
		employeeRepo.createEmp(e);
		return e;
	}
}
