package com.pramati.learning.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		String uname = (String) req.getParameter("login");
		String pwd = (String) req.getParameter("pwd");
		
		if (uname.equals(pwd))
			out.println("Successfully logged");

	}

}
