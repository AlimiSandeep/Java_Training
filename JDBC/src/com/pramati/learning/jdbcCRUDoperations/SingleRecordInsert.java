package com.pramati.learning.jdbcCRUDoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SingleRecordInsert {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			PreparedStatement ps = conn.prepareStatement("insert into employee values(?,?,?,?)");
			
			ps.setInt(1,1000);
			ps.setString(2, "Sandeep");
			ps.setInt(3, 50000);
			ps.setString(4, "Hyderabad");

			int res=ps.executeUpdate();
			System.out.println(res+" records inserted");
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
