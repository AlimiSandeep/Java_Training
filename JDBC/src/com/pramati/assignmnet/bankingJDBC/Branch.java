package com.pramati.assignmnet.bankingJDBC;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Branch {

	static Scanner in = new Scanner(System.in);
	static Map<String, Customer> map = BranchDao.getCustomers();

	public void transfer(int cust_id, Customer customer, double amount) {
		Account account = customer.getAcnt();
		AccountDao accDao = new AccountDao();
		double balance = accDao.getBalance(cust_id);
		account.setBalance(balance);

		if (account.withdraw(amount)) {
			System.out.println("Enter name of the customer u want to transfer");
			map.keySet().stream().filter(e -> !e.equals(customer.getName())).forEach(e -> System.out.print(e + "\t"));
			System.out.println();

			Customer toDeposit = map.get(in.next());
			Account toDepositAcc = toDeposit.getAcnt();
			Transaction transaction = new Transaction(customer.getName(), toDeposit.getName(), amount, "transfer");
			account.recordTransaction(transaction);

			double money = accDao.getBalance(toDeposit.getName());

	
			toDepositAcc.setBalance(money);
		
			toDepositAcc.deposit(amount);
			
			Transaction transaction2 = new Transaction(customer.getName(), toDeposit.getName(), amount, "transfer");
			toDepositAcc.recordTransaction(transaction2);
			System.out.println("Transferred " + amount + "  successfully from " + customer.getName() + " to "
					+ toDeposit.getName());

			accDao.withdraw(cust_id, amount);
			accDao.depositToOther(toDeposit.getName(), toDepositAcc.getBalance());

			TransactionDao transDao = new TransactionDao();
			transDao.recordTransaction(cust_id, customer.getName(), toDeposit.getName(), amount, "transfer");

		} else {
			System.out.println("Insufficient balance for transfer");
			System.out.println("Your bank balance is :" + account.getBalance());
		}

	}

	public void deposit(int cust_id, Customer customer, double amount) {

		Account account = null;
		AccountDao accDao = new AccountDao();
		double balance = accDao.getBalance(cust_id);

		System.out.println("1-Deposit to self\n2-Deposit to other");
		switch (in.nextInt()) {
		case 1:
			account = customer.getAcnt();
			account.setBalance(balance);
			if (account.deposit(amount)) {
				System.out.println("Deposited successfully " + amount);
				Transaction transaction1 = new Transaction(customer.getName(), customer.getName(), amount, "deposit");
				account.recordTransaction(transaction1);

				accDao.depositToSelf(cust_id, account.getBalance());
				TransactionDao transDao = new TransactionDao();
				transDao.recordTransaction(cust_id, customer.getName(), customer.getName(), amount, "deposit");
			}
			break;

		case 2:
			System.out.println("Enter name of the customer u want to deposit");
			map.keySet().stream().filter(e -> !e.equals(customer.getName())).forEach(e -> System.out.print(e + "\t"));
			System.out.println();
			String name = in.next();
			Customer toDeposit = map.get(name);
			Account toDepositAcc = toDeposit.getAcnt();
			toDepositAcc.setBalance(accDao.getBalance(name));
			if (toDepositAcc.deposit(amount)) {
				System.out.println("Deposited successfully " + amount);
				Transaction transaction2 = new Transaction(customer.getName(), toDeposit.getName(), amount, "deposit");
				toDepositAcc.recordTransaction(transaction2);

				
				accDao.depositToOther(name, toDepositAcc.getBalance());
				TransactionDao transDao = new TransactionDao();
				transDao.recordTransaction(cust_id, customer.getName(), toDeposit.getName(), amount, "deposit");
			}

			break;

		default:
			break;
		}

	}

	public void withdraw(int cust_id, Customer customer, double amount) {
		Account account = customer.getAcnt();
		AccountDao accDao = new AccountDao();
		account.setBalance(accDao.getBalance(cust_id));
		if (account.withdraw(amount)) {
			System.out.println("Successfully withdrawed " + amount);
			Transaction transaction = new Transaction(customer.getName(), customer.getName(), amount, "withdrawl");
			account.recordTransaction(transaction);

			accDao.withdraw(cust_id, amount);
			TransactionDao transDao = new TransactionDao();
			transDao.recordTransaction(cust_id, customer.getName(), customer.getName(), amount, "withdrawl");
		}

		else {
			System.out.println("Insufficient balance");
			System.out.println("Your bank balance is :" + account.getBalance());
		}

	}

	public void displayBalance(int cust_id, Customer customer) {
		AccountDao accDao = new AccountDao();
		double balance = accDao.getBalance(cust_id);
		System.out.println("Balance in your account is " + balance);

	}

	public void doOperation(Customer customer, int cust_id) {
		Account acnt = customer.getAcnt();
		char choice;
		do {

			System.out.println("1-Deposit\n2-Withdraw\n3-Display balance\n4-Transfer\n5-Transaction History");
			int operation = in.nextInt();
			switch (operation) {
			case 1:
				System.out.println("Enter the amount to deposit");
				deposit(cust_id, customer, in.nextDouble());
				break;

			case 2:
				System.out.println("Enter amount to withdraw");
				double amt = in.nextDouble();
				withdraw(cust_id, customer, amt);

				break;

			case 3:
				displayBalance(cust_id, customer);
				break;
			case 4:
				System.out.println("Enter the amount to transfer");
				double amount = in.nextDouble();
				transfer(cust_id, customer, amount);
				break;
			case 5:
				acnt.getList().stream().forEach(System.out::println);
				break;

			default:
				System.out.println("No Operation found");

			}

			System.out.println("Do you want to perform another operation:[y/n]");
			choice = in.next().charAt(0);

		} while (choice == 'y');

	}

	public static void main(String[] args) {
		Branch branch = new Branch();

		List<String> list = new LinkedList<>();
		list.addAll(map.keySet());
		char choice;
		do {
			int i = 1;
			for (String str : list) {
				System.out.print(i++ + "-" + str + "\t");
			}
			System.out.println();

			int option = in.nextInt();

			branch.doOperation(map.get(list.get(option - 1)), option);

			System.out.println("Do you want to continue[y/n]:");
			choice = in.next().charAt(0);

		} while (choice == 'y');

	}

}