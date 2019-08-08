package com.pramati.xmlusage;


public class Employee {
	private int empId;
	private String name;
	private Address address;

	public Employee(int empId, String name, Address address) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	public void display() {
		System.out.println(empId + " " + name);
		System.out.println(address);

	}
}
