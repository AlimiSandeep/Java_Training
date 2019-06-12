package com.pramati.assignment.banking;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private double balance = 0;
	private List<Transaction> list = new ArrayList<Transaction>();

	public void deposit(double amt) {
		balance += amt;

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

	public List<Transaction> getList() {
		return list;
	}

}
