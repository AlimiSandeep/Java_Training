package com.pramati.learning.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet2 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		Cookie[] ck=req.getCookies();
		String name=ck[0].getValue();
		
		pw.println("<h3>Good Morning...."+name+"</h3><br>");
		pw.print("This is from Servlet-2");
}
}