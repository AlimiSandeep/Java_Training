package com.pramati.learning.eventsInServlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountUserListener implements HttpSessionListener  {
ServletContext cxt=null;

	static int current=0,total=0;
	public void sessionCreated(HttpSessionEvent e) {
		
		current++;
		total++;
		cxt=e.getSession().getServletContext();
		cxt.setAttribute("totalUsers", total);
		cxt.setAttribute("currentUsers", current);
		
	}

	public void sessionDestroyed(HttpSessionEvent e) {
		current--;
		cxt.setAttribute("currentUsers", current);
	}

}
