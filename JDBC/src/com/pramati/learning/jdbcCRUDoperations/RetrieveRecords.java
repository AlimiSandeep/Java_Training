package com.pramati.learning.jdbcCRUDoperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class RetrieveRecords {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("connection.properties");
			Properties prop = new Properties();
			prop.load(fis);

			Class.forName(prop.getProperty("driver"));

			Connection conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
					prop.getProperty("pwd"));

			PreparedStatement ps = conn.prepareStatement("select * from employee");

			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("----------------------------------");
			for (int i = 1; i <= rsmd.getColumnCount(); i++)
				System.out.print(rsmd.getColumnName(i).toUpperCase() + "\t");
			System.out.println();
			System.out.println("----------------------------------");

			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getInt(3) + "\t");
				System.out.println(rs.getString(4) + "\t");

			}

			System.out.println("------------------------------------");

			rs.last();
			System.out.println(rs.getRow());
			System.out.print(rs.getInt(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			System.out.print(rs.getInt(3) + "\t");
			System.out.println(rs.getString(4) + "\t");

			rs.absolute(3);
			System.out.println(rs.getRow());
			System.out.print(rs.getInt(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			System.out.print(rs.getInt(3) + "\t");
			System.out.println(rs.getString(4) + "\t");

			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
