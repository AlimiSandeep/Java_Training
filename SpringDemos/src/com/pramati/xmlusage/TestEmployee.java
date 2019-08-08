package com.pramati.xmlusage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmployee {

	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("spring.xml");

		Employee emp = (Employee) factory.getBean("emp");
		emp.display();

	}

}
