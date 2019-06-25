package com.pramati.assignmnet.bankingJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDao {
	static private Connection conn = null;
	private AccountDao accDao = new AccountDao();

	public void recordTransaction(int cust_id, String fromAcc, String toAcc, double amt, String operation) {

		try {
			conn = DBConnection.getConnection();
			PreparedStatement ps1 = conn.prepareStatement(
					"insert into transactions(fromAcc,toAcc,amount,operation,acc_id) values(?,?,?,?,?)");
			ps1.setString(1, fromAcc);
			ps1.setString(2, toAcc);
			ps1.setDouble(3, amt);
			ps1.setString(4, operation);
			ps1.setInt(5, accDao.getAccount(cust_id));
			ps1.executeUpdate();

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
