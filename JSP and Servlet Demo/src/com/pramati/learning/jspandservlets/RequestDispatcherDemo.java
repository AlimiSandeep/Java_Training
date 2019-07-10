package com.pramati.learning.jspandservlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDispatcherDemo extends HttpServlet {

	public RequestDispatcherDemo() {
		System.out.println("Inside no-arg constructor");
	}

	@Override
	public void init() throws ServletException {

		super.init();
		System.out.println("Inside init() method");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		System.out.println("Inside service()  method");

	}

	@Override
	public void destroy() {

		super.destroy();
		System.out.println("Inside destroy() method");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/output.jsp");

		String firstName = req.getParameter("fname");
		String lastName = req.getParameter("lname");
		if (firstName.isEmpty()) {
			req.setAttribute("Name", "First Name cannot be empty");

			dispatcher.forward(req, resp);
			return;

		}
		if (lastName.isEmpty()) {
			req.setAttribute("Name", "Last Name cannot be empty");

			dispatcher.forward(req, resp);
			return;

		}

		String fullName = firstName + " " + lastName;
		req.setAttribute("Name", fullName);
		dispatcher.forward(req, resp);
	}

}
