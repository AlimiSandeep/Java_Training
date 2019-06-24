package com.pramati.learning.jdbcCRUDoperations;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveImage {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			PreparedStatement ps = conn.prepareStatement("select * from IMGTABLE");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Blob b = rs.getBlob(2);
				byte barr[] = b.getBytes(1, (int) b.length());

				FileOutputStream fout = new FileOutputStream("/home/sandeepa/sasuke.jpg");
				fout.write(barr);

				fout.close();
			}

			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
