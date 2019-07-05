package com.pramati.learning.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBConnectionUsingServletConfig extends HttpServlet {
	ServletConfig config = null;

	public void init(ServletConfig config) {
		this.config = config;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String driver = config.getInitParameter("driver");
		String url = config.getInitParameter("url");
		String uname = config.getInitParameter("uname");
		String passwd = config.getInitParameter("passwd");
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, uname, passwd);
			PreparedStatement ps = conn.prepareStatement("select song_name,song_duration,singer from songs");
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			pw.println("<table border=2 align=center>");
			pw.println("\n"
					+ "<thead>\n" + 
					"<td>Song Name</td>\n" + 
					"<td>Duration</td>\n" + 
					"<td>Singer</td>\n" + 
					"</thead>");
			while (rs.next()) {
				pw.println("\n" + 
						"<tr>\n" + 
						"<td>"+rs.getString("song_name")+"</td>\n" + 
						"<td>"+rs.getString("song_duration")+"</td>\n" + 
						"<td>"+rs.getString("singer")+"</td>\n" + 
						"</tr>");

			}
			pw.println("</table>");

			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
