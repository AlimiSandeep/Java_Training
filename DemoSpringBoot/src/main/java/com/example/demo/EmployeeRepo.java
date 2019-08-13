package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public class EmployeeRepo {

	private static List<Employee> list;

	public EmployeeRepo() {
		list = new ArrayList<>();

		Employee e1 = new Employee();
		e1.setEmpId(1001);
		e1.setEmpName("Ja");
		e1.setSal(20000);

		Employee e2 = new Employee();
		e2.setEmpId(1002);
		e2.setEmpName("Jhon");
		e2.setSal(30000);

		list.add(e1);
		list.add(e2);

	}

	public List<Employee> getEmployees() {
		return list;
	}

	public void createEmp(Employee e) {
		list.add(e);

	}

}
