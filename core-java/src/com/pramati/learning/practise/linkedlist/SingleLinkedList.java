package com.pramati.learning.practise.linkedlist;

import java.util.Scanner;

public class SingleLinkedList {
	Node head;
	static int count = 0;
	Scanner in = new Scanner(System.in);

	class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}

	}

	public void insertAtEnd(int data) {
		Node new_node = new Node(data, null);
		if (head == null) {
			head = new_node;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new_node;

		}
		count++;
		// System.out.println(count);

		return ;
	}

	

	public void insertAtBeginning( int data) {
		Node new_node;
		if (head != null) {
			new_node = new Node(data, head);
			head = new_node;
		} else {
			new_node = new Node(data, null);
			head = new_node;
		}

		count++;
		// System.out.println(count);
		return ;

	}

	public void insertAtSpecifiedPosition(int data, int position) {
		Node new_node = new Node(data, null);
		Node temp = head;
		if (position == 1) {
		insertAtBeginning(data);
			return ;
		}
		if (position <= count + 1) {

			if (position == count + 1) {

				insertAtEnd(data);
			} else {
				for (int i = 2; i < position; i++) {
					temp = temp.next;
				}
				new_node.next = temp.next;
				temp.next = new_node;

				count++;
				// System.out.println(count);

			}
		} else {
			System.out.println("Position out of range");
		}

		return ;

	}

	

	public void deleteAtBeginning() {
		if (head == null) {
			System.out.println("No elements to delete");
			return;
		}
		Node temp = head;
		head = temp.next;
		System.out.println(temp.data + " deleted");
		temp = null;

		count--;
		// System.out.println(count);

		return;

	}

	public void deleteAtEnd() {
		if (head == null) {
			System.out.println("No elements to delete");
			return;
		}
		Node temp1 = head;
		Node temp2 = null;
		while (temp1.next != null) {
			temp2 = temp1;
			temp1 = temp1.next;

		}
		temp2.next = null;
		System.out.println(temp1.data + " deleted");
		temp1 = null;

		count--;
		// System.out.println(count);

		return;
	}

	public void deleteAtSpecifiedPosition(int position) {
		Node temp1 = head;
		Node temp2 = null;
		if (head == null) {
			System.out.println("No elements to delete");
			return;
		}
		if (position == 1) {
		deleteAtBeginning();
			return;
		}
		if (position <= count) {

			if (position == count) {
				deleteAtEnd();
			} else {
				for (int i = 2; i <= position; i++) {
					temp2 = temp1;
					temp1 = temp1.next;
				}
				temp2.next = temp1.next;
				System.out.println(temp1.data + " deleted");
				temp1 = null;

				count--;
				// System.out.println(count);

			}

		} else {
			System.out.println("Position out of range");
		}

		return;

	}

	public void search(int element) {
		Node temp = head;
		for (int i = 1; i <= count; i++) {
			if (temp.data == element) {
				System.out.println("Element found at " + i + " position");
				return;
			} else
				temp = temp.next;
		}
		System.out.println("Element " + element + " doesnt exists");

		return;
	}

	// Printing linked list manually
	public void printList() {
		Node temp = head;
		if (temp == null)
			System.out.println("No elements to display");
		else {
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
			System.out.println();
		}

	}

	// Printing linked list normally through recursion
	/*
	 * public void printList(Node node) { 
	 * if (node == null)
	 *  return;
	 * 
	 * System.out.print(node.data + " ");
	 * 
	 * printList(node.next);
	 * 
	 * }
	 */

	public void printReverse(Node node) {
		if (node == null) {
			System.out.println("No elements to display");
			return;
		}

		printReverse(node.next);

		System.out.print(node.data + " ");

	}

}
