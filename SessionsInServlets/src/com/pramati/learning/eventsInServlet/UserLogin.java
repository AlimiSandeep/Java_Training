package com.pramati.learning.eventsInServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		String name = req.getParameter("uname");
		String pwd = req.getParameter("passwd");
		if (name.equals(pwd)) {
			pw.println("<h3>Welcome <i>" + name + "</i></h3>");
			HttpSession session = req.getSession();
			session.setAttribute("uname", name);
			ServletContext cxt = getServletContext();
			int tot = (Integer) cxt.getAttribute("totalUsers");
			int cur = (Integer) cxt.getAttribute("currentUsers");
			pw.println("Total users =" + tot);
			pw.println("Current users =" + cur);
			
			pw.println("<br><a href='userlogout'>Logout</a>");

		} else {
			pw.println("Sorry,wrong password!!...Try again<br>");
			req.getRequestDispatcher("index.html").include(req, resp);
		}
		
		
	}
}
