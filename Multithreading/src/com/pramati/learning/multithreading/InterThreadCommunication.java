package com.pramati.learning.multithreading;

class Customer {
	int amount = 10000;

	synchronized void withdraw(int amount) {
		System.out.println("Going to withdrawl");

		if (this.amount < amount) {
			System.out.println("Less balance..waiting for deposit");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.amount -= amount;
		System.out.println("Withdrawl completed");
	}

	synchronized void deposit(int amount) {
		this.amount += amount;
		System.out.println("Deposited amt");
		notify();
	}

}

class Withdrwal extends Thread {
	Customer c;

	public Withdrwal(Customer cust) {
		this.c = cust;
	}

	public void run() {
		c.withdraw(15000);
	}
}

class Deposit extends Thread {
	Customer c;

	public Deposit(Customer cust) {
		this.c = cust;
	}

	public void run() {
		c.deposit(15000);
	}
}

/*
 * public class InterThreadCommunication { public static void main(String[]
 * args) {
 * 
 * Customer c = new Customer(); Thread t1 = new Thread() { public void run() {
 * c.withdraw(15000);
 * 
 * }
 * 
 * };
 * 
 * t1.start(); Thread t2 = new Thread() { public void run() { c.deposit(6000);
 * 
 * }
 * 
 * };
 * 
 * t2.start(); }
 * 
 * }
 */
public class InterThreadCommunication {
	public static void main(String[] args) {
		Customer c = new Customer();
		Withdrwal w = new Withdrwal(c);
		Deposit d = new Deposit(c);
		w.start();
		d.start();
	}
}
