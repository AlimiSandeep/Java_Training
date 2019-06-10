package com.pramati.learning.practise.linkedlistwithgenerics;

import java.util.Scanner;

public class StackUsingLinkedListGenerics_Client {

	public static void main(String[] args) {
		StackUsingLinkedListGenerics<String> stack = new StackUsingLinkedListGenerics<>();
		Scanner in = new Scanner(System.in);
		char choice;
		do {

			System.out.println("1-Push\n2-Pop\n3-Peek\n4-Display\n5-Exit");
			int option = in.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter the data to be pushed");
				stack.push(in.next());
				break;

			case 2:
				stack.pop();
				break;

			case 3:
				stack.peek();
				break;
			case 4:
				for(String data: stack)
					System.out.println(data);
				break;
			case 5:
				System.out.println("Exiting...");
				System.exit(0);
			default:
				System.out.println("No option found........");

			}
			System.out.print("Do u want to continue [y/n]:");
			choice = in.next().charAt(0);

		} while (choice == 'y');

		in.close();

	}
}
