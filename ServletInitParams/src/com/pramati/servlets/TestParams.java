package com.pramati.servlets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns = "/testparams"
		)
public class TestParams extends HttpServlet {
	ServletConfig config=null;

	public void init(ServletConfig config){
		this.config=config;
		try {
			FileInputStream fis=new FileInputStream("config.properties");
			Properties prop = new Properties();
			prop.load(fis);
			
			config.getServletContext().setInitParameter("fname", prop.getProperty("firstname"));
			config.getServletContext().setInitParameter("lname", prop.getProperty("lastname"));
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		pw.println(config.getInitParameter("fname"));
	}
}
