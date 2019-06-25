package com.pramati.assignmnet.bankingJDBC;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private double balance = 0;
	private List<Transaction> list = new ArrayList<Transaction>();

	public boolean deposit(double amt) {
		balance += amt;
		return true;

	}

	public boolean withdraw(double amt) {
		if(balance>=amt)
		{
			balance-=amt;
			return true;
		}
		
		return false;

	}

	public void recordTransaction(Transaction transaction) {
		list.add(transaction);
	}

	public double getBalance() {
		return balance;
	}
	
	

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Transaction> getList() {
		return list;
	}

}
