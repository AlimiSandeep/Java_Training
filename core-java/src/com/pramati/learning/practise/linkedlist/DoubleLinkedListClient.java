package com.pramati.learning.practise.linkedlist;

import java.util.Scanner;

public class DoubleLinkedListClient {
	static Scanner in = new Scanner(System.in);
	static DoubleLinkedList dll = new DoubleLinkedList();

	public static void main(String[] args) {

		DoubleLinkedListClient dllClient = new DoubleLinkedListClient();
		char choice;

		do {
			System.out.println("1-Insert\n2-Delete\n3-Display\n4-Search\n5-Print Reverse\n6-Exit");
			int option = in.nextInt();
			switch (option) {
			case 1:
				dllClient.insert();
				break;

			case 2:
				dllClient.delete();
				break;

			case 3:
				dll.printList(dll.first);
				break;
			case 4:
				System.out.println("Enter element to be searched:");
				int element = in.nextInt();
				dll.search(element);
				break;

			case 5:

				dll.printReverse();
				break;

			case 6:

				System.out.println("Exiting....");
				System.exit(0);

			default:
				System.out.println("No option found........");

			}

			System.out.print("Do u want to continue [y/n]:");
			choice = in.next().charAt(0);

		} while (choice == 'y');

		in.close();

	}

	public void insert() {

		System.out.println("1-Insert at Beginning\n2-Insert at End\n3-Insert at specified position");
		int option = in.nextInt();
		int data;
		switch (option) {
		case 1:
			System.out.print("Enter the element:");
			data = in.nextInt();
			dll.insertAtBeginning(data);
			break;

		case 2:
			System.out.print("Enter the element:");
			data = in.nextInt();
			dll.insertAtEnd(data);
			break;
		case 3:
			System.out.print("Enter the element:");
			data = in.nextInt();
			System.out.println("Enter the position:");
			int position = in.nextInt();
			dll.insertAtSpecifiedPosition(data, position);
			break;

		default:
			System.out.println("No option found........");
		}

	}

	public void delete() {
		System.out.println("1-Delete at Beginning\n2-Delete a End\n3-Delete at specified position");
		int option = in.nextInt();
		switch (option) {
		case 1:
			dll.deleteAtBeginning();
			break;
		case 2:
			dll.deleteAtEnd();
			break;
		case 3:
			System.out.println("Enter the position to delete");
			int position = in.nextInt();
			dll.deleteAtSpecifiedPosition(position);
			break;
		default:
			System.out.println("Option not found..");
			break;
		}

	}

}
