package com.pramati.aopdemo;

import org.springframework.stereotype.Component;

@Component
public class Operation {

	public void m() {
		System.out.println("m() method invoked ");
//		return 1;

	}

	public void n() {
		System.out.println("n() method invoked ");
//		return 2;

	}

	public void validate(int age) throws Exception {
		if (age < 18) {
			throw new ArithmeticException("Not valid age");
		} else {
			System.out.println("Thanks for vote");
		}
	}
}
