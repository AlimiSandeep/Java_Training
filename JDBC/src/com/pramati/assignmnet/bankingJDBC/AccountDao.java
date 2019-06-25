package com.pramati.assignmnet.bankingJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {

	static private Connection conn = null;
	private double balance = 0;

	public int getAccount(int cust_id) {
		int acc_id = 0;
		try {

			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select acc_id from customer where cust_id=?");
			ps.setInt(1, cust_id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			acc_id = rs.getInt(1);
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return acc_id;
	}

	public int getAccount(String name) {
		int acc_id = 0;
		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select acc_id from customer where cust_name=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			rs.next();
			acc_id = rs.getInt(1);
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return acc_id;
	}

	public double getBalance(int cust_id) {
		try {

			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select balance from account where acc_id=?");
			ps.setInt(1, getAccount(cust_id));
			ResultSet rs = ps.executeQuery();
			rs.next();
			balance = rs.getDouble(1);
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return balance;
	}
	public double getBalance(String name) {
		try {

			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select balance from account where acc_id=?");
			ps.setInt(1, getAccount(name));
			ResultSet rs = ps.executeQuery();
			rs.next();
			balance = rs.getDouble(1);
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return balance;
	}

	public void depositToSelf(int cust_id, double amt) {

		try {

			conn = DBConnection.getConnection();
			PreparedStatement ps1 = conn.prepareStatement("update account set balance=? where acc_id=?");
			ps1.setDouble(1, amt);
			ps1.setInt(2, getAccount(cust_id));
			ps1.executeUpdate();

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void depositToOther(String name, double amt) {
		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps1 = conn.prepareStatement("update account set balance=? where acc_id=?");
			ps1.setDouble(1, amt);
			ps1.setInt(2, getAccount(name));
			ps1.executeUpdate();

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void withdraw(int cust_id, double amt) {

		int amount = 0;
		try {

			conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("select balance from account where acc_id=?");
			ps.setInt(1, getAccount(cust_id));
			ResultSet rs = ps.executeQuery();
			rs.next();
			amount = rs.getInt(1);
			depositToSelf(cust_id, amount - amt);
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
