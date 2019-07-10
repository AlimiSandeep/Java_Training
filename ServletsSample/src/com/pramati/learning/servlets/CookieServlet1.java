package com.pramati.learning.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet1 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String name = req.getParameter("name");

		pw.println("<h3>Hello..." + name+"</h3>");
		pw.print("<br>");
		pw.print("This is from Servlet-1");

		Cookie ck = new Cookie("name", name);
		resp.addCookie(ck);
		
		pw.print("<form action='servlet2' method='post'>") ; 
		pw.print("<input type='submit' value='Go'/>" );
		pw.print("</form>");
	}
}
