package com.pramati.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestEmployee {

	public static void main(String[] args) {
		ApplicationContext factory = new AnnotationConfigApplicationContext(ConfigClass.class);

		Employee emp = factory.getBean(Employee.class);
		emp.display();

	}

}
