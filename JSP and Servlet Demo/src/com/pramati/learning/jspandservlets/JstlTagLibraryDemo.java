package com.pramati.learning.jspandservlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JstlTagLibraryDemo extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String location = req.getParameter("location");

		Student student = new Student();
		student.setName(name);
		student.setAge(Integer.parseInt(age));
		student.setLocation(location);
		
		req.setAttribute("student", student);

		List<Student> list = new ArrayList<Student>();
		list.add(student);

		student = new Student();
		student.setName("Vivek");
		student.setAge(21);
		student.setLocation("India");

		list.add(student);

		student = new Student();
		student.setName("Vyshu");
		student.setAge(21);
		student.setLocation("India");

		list.add(student);
		
		req.setAttribute("list", list);

		String hobbies[] = { "Cooking", "Playing BAdminton", "Drawing" };
		req.setAttribute("hobbies", hobbies);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/studentop.jsp");
		dispatcher.forward(req, resp);

	}
}
