package com.pramati.learning.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HiddenServlet1 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String name = req.getParameter("name");

		pw.println("<h3>Hello..." + name + "</h3>");
		pw.print("<br>");

		// pw.print("<form action='hiddenservlet2' method='post'>") ;
		// pw.print("<input type='hidden' name='user' value='"+name+"'/>");
		// pw.print("</form>");

		pw.print("<a href='hiddenservlet2?user=" + name + "'><input type='button' value='Go'/></a>");

	}
}
