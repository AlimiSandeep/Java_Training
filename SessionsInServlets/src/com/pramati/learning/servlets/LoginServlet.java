package com.pramati.learning.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter pw=resp.getWriter();
	
	pw.print("<a href='ProfileServlet'>Profile</a>&nbsp&nbsp|");
	pw.println("&nbsp&nbsp<a href='LogoutServlet'>Logout</a><br><hr>");
	pw.println("<br>");
	
	String name=req.getParameter("uname");
	String pwd=req.getParameter("passwd");
	
	

	if(name.equals(pwd))
	{
		pw.println("<h4>Logged in successfully</h4>");
		pw.println("Welcome "+name);
		HttpSession session=req.getSession();
		session.setAttribute("uname", name);
		
	}
	else
	{
		pw.println("Sorry,password wrong!!..Try again.....<br><br>");
		req.getRequestDispatcher("login.html").include(req, resp);
	}
	
}
}
