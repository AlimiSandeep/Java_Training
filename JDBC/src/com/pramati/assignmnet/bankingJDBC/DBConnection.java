package com.pramati.assignmnet.bankingJDBC;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	private static Connection conn = null;

	private DBConnection() {
		super();

	}

	public static Connection getConnection() {
		try {
			FileInputStream fis = new FileInputStream("connection.properties");
			Properties prop = new Properties();
			prop.load(fis);

			Class.forName(prop.getProperty("driver"));

			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
					prop.getProperty("pwd"));

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

		return conn;
	}

}
