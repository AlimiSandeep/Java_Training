package com.pramati.learning.practise.linkedlist;

import java.util.Scanner;

public class QueueUsingLinkedListClient {
	public static void main(String[] args) {
		QueueUsingLinkedList queue = new QueueUsingLinkedList();
		Scanner in = new Scanner(System.in);
		char choice;
		do {

			System.out.println("1-Insert\n2-Remove\n3-Peek\n4-Display\n5-Exit");
			int option = in.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter the data to be pushed");
				queue.insert(in.nextInt());
				break;

			case 2:
				queue.remove();
				break;

			case 3:
				queue.peek();
				break;
			case 4:
				queue.display();
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
