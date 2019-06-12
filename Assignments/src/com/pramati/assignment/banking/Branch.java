package com.pramati.assignment.banking;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Branch {

	static Scanner in = new Scanner(System.in);
	static Map<String, Customer> map = new LinkedHashMap<>();

	static {

		map.put("Bob", new Customer("Bob"));
		map.put("Alice", new Customer("Alice"));
		map.put("Tom", new Customer("Tom"));
	}

	public static void deposit(Customer customer, double amount) {

		System.out.println("1-Deposit to self\n2-Deposit to other");
		switch (in.nextInt()) {
		case 1:
			Account account = customer.getAcnt();
			account.deposit(amount);
			Transaction transaction1 = new Transaction(customer.getName(), customer.getName(), amount, "deposit");
			account.recordTransaction(transaction1);
			break;

		case 2:
			System.out.println("Enter name of the customer u want to deposit");
			map.keySet().stream().filter(e -> e != customer.getName()).forEach(e -> System.out.print(e + "\t"));
			Customer toDeposit = map.get(in.next());
			Account toDepositAcc = toDeposit.getAcnt();
			toDepositAcc.deposit(amount);
			Transaction transaction2 = new Transaction(customer.getName(), toDeposit.getName(), amount, "deposit");
			toDepositAcc.recordTransaction(transaction2);

			break;

		default:
			break;
		}

	}

	public static void withdraw(Customer customer, double amount) {
		Account account = customer.getAcnt();
		if (account.withdraw(amount)) {
			System.out.println("Successfully withdrawed " + amount);
			Transaction transaction = new Transaction(customer.getName(), customer.getName(), amount, "withdrawl");
			account.recordTransaction(transaction);
		}

		else
			System.out.println("Insufficient balance");

	}

	public void doOperation(Customer customer) {
		Account acnt = customer.getAcnt();

		char choice;
		do {

			System.out.println("1-Deposit\n2-Withdraw\n3-Display balance\n4-Transaction History");
			int operation = in.nextInt();
			switch (operation) {
			case 1:
				System.out.println("Enter the amount to deposit");
				deposit(customer, in.nextDouble());
				break;

			case 2:
				System.out.println("Enter amount to withdraw");
				double amt = in.nextDouble();
				withdraw(customer, amt);

				break;

			case 3:
				System.out.println(acnt.getBalance());
				break;

			case 4:
				acnt.getList().stream().forEach(System.out::println);
				break;

			default:
				System.out.println("No Operation found");

			}

			System.out.println("Do you want to perform another opration:[y/n]");
			choice = in.next().charAt(0);

		} while (choice == 'y');

	}

	public static void main(String[] args) {
		Branch branch = new Branch();

		char choice;
		do {
			System.out.println("1-Bob\t2-Alice\t3-Tom");
			int option = in.nextInt();

			switch (option) {
			case 1:

				branch.doOperation(map.get("Bob"));
				break;

			case 2:
				branch.doOperation(map.get("Alice"));
				break;

			case 3:
				branch.doOperation(map.get("Tom"));
				break;

			default:
				System.out.println("No Customer found..");
			}

			System.out.println("Do you want to continue[y/n]:");
			choice = in.next().charAt(0);

		} while (choice == 'y');

	}

}