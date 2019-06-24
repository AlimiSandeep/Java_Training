package com.pramati.learning.jdbcCRUDoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchInsert {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			PreparedStatement ps = conn.prepareStatement("insert into employee values(?,?,?,?)");
			Scanner in = new Scanner(System.in);
			while (true) {

				System.out.println("Enter id");
				int id = in.nextInt();

				System.out.println("Enter name");
				String name = in.next();

				System.out.println("Enter salary");
				int sal = in.nextInt();

				System.out.println("Enter location");
				String loc = in.next();

				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setInt(3, sal);
				ps.setString(4, loc);

				ps.addBatch();

				System.out.println("Want to add more records y/n");
				char ans = in.next().charAt(0);
				if (ans == 'n') {
					break;
				}

			}
			
			int res[] =ps.executeBatch();

			System.out.println(res.length + " records inserted");

			in.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
