package com.pramati.assignment.banking;

public class Transaction {
	private String fromAcc;
	private String toAcc;
	private double amount;
	private String operation;

	public Transaction(String fromAcc, String toAcc, double amount, String operation) {
		super();
		this.fromAcc = fromAcc;
		this.toAcc = toAcc;
		this.amount = amount;
		this.operation = operation;
	}

	public String getFromAcc() {
		return fromAcc;
	}

	public String getToAcc() {
		return toAcc;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return fromAcc + " " + toAcc + " " + amount + " " + operation;
	}

}
