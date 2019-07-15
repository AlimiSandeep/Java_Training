package com.pramati.learning.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		pw.print("<a href='LogoutServlet'>Logout</a><br><hr>");
		HttpSession session = req.getSession(false);
		if (session != null) {
			String name = (String) session.getAttribute("uname");
			pw.print("<p>Hii <b>" + name + "</b></p> Welcome to the profile");
			
		} else {
			pw.println("Please Login first......");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
	}
}
