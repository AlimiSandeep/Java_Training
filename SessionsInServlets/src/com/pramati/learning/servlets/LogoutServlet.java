package com.pramati.learning.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
			pw.print("<h3 align='center'>Logged out successfully</h3>");
		} else {
			pw.print("Please login first...");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
	}
}
