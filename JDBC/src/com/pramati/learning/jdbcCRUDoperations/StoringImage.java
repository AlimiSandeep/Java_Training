package com.pramati.learning.jdbcCRUDoperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class StoringImage {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			PreparedStatement ps = conn.prepareStatement("insert into IMGTABLE values(?,?)");
			ps.setString(1, "sasuke");
			FileInputStream fis = new FileInputStream("/home/sandeepa/Downloads/sasuke.jpg");
			ps.setBinaryStream(2, fis, fis.available());

			if(ps.executeUpdate()>0)
				System.out.println("Record inserted");

			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
