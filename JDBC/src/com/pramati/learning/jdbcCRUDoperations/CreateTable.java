package com.pramati.learning.jdbcCRUDoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			Statement stmt=conn.createStatement();
			String sql="create table employee(empid int primary key,empname varchar(10) not null,salary int check(salary>10000),location varchar(20));";
			int res=stmt.executeUpdate(sql);
			if(res>=0)
				System.out.println("Table created");
			
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
