package com.pramati.aopdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestOperation {
	public static void main(String[] args) {
		ApplicationContext factory = new AnnotationConfigApplicationContext(Config.class);

		Operation operation = factory.getBean(Operation.class);
		operation.m();
		operation.n();

		try {
			operation.validate(17);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
