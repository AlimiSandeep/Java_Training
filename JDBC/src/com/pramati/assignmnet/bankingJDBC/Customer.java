package com.pramati.assignmnet.bankingJDBC;

public class Customer {
	private String name;

	private Account acnt = new Account();

	public Customer(String name) {
		super();
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public Account getAcnt() {
		return acnt;
	}

}
