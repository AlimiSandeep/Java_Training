package com.pramati.assignmnet.bankingJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class BranchDao {

	static Connection conn = null;
	static private Map<String, Customer> map = new LinkedHashMap<>();

	public static Map<String, Customer> getCustomers() {

		try {

			conn = DBConnection.getConnection();

			PreparedStatement ps = conn.prepareStatement("select cust_name from customer");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				map.put(rs.getString("cust_name"), new Customer(rs.getString("cust_name")));
			}

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return map;

	}
}
