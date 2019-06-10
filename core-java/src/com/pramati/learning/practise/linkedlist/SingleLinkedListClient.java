package com.pramati.learning.practise.linkedlist;

import java.util.Scanner;

public class SingleLinkedListClient {
	static Scanner in = new Scanner(System.in);
	static SingleLinkedList sll = new SingleLinkedList();

	public static void main(String[] args) {
		SingleLinkedListClient sllClient=new SingleLinkedListClient();
				char choice;

		do {
			System.out.println("1-Insert\n2-Delete\n3-Display\n4-Search\n5-Print Reverse\n6-Exit");
			int option = in.nextInt();
			switch (option) {
			case 1:
				sllClient.insert();
				break;

			case 2:
				sllClient.delete();
				break;

			case 3:
				sll.printList();
				break;

			case 4:
				System.out.println("Enter element to be searched:");
				int element = in.nextInt();
				sll.search(element);
				break;

			case 5:

				sll.printReverse(sll.head);
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
			sll.insertAtBeginning(data);
			break;

		case 2:
			System.out.print("Enter the element:");
			data = in.nextInt();
			sll.insertAtEnd(data);
			break;
		case 3:
			System.out.print("Enter the element:");
			data = in.nextInt();
			System.out.println("Enter the position:");
			int position = in.nextInt();
			sll.insertAtSpecifiedPosition(data, position);
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
			sll.deleteAtBeginning();
			break;
		case 2:
			sll.deleteAtEnd();
			break;
		case 3:
			System.out.println("Enter the position to delete");
			int position = in.nextInt();
			sll.deleteAtSpecifiedPosition( position);
			break;
		default:
			System.out.println("Option not found..");
			break;
		}

	}

}
