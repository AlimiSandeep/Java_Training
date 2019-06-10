package com.pramati.learning.practise.linkedlist;

import java.util.Scanner;

public class DoubleLinkedList {
	Node first;
	Node last;
	static int count = 0;
	Scanner in = new Scanner(System.in);

	class Node {
		int data;
		Node next;
		Node prev;

		public Node(int data, Node next, Node prev) {
			super();
			this.data = data;
			this.next = next;
			this.prev = prev;
		}

	}

	public void insertAtBeginning(int data) {
		Node new_node;
		if (first == null && last == null) {

			new_node = new Node(data, null, null);
			first = last = new_node;

		} else {
			new_node = new Node(data, first, null);
			first.prev = new_node;
			first = new_node;
		}

		count++;
		// System.out.println(count);
		return;

	}

	public void insertAtEnd(int data) {
		Node new_node = new Node(data, null, null);
		if (first == null && last == null) {
			first = last = new_node;
		} else {
			Node temp = first;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new_node;
			new_node.prev = temp;
			last = new_node;

		}
		count++;
		// System.out.println(count);

		return;
	}

	public void insertAtSpecifiedPosition(int data, int position) {
		Node new_node = new Node(data, null, null);
		Node temp = first;
		if (position == 1) {
			insertAtBeginning(data);
			return;
		}
		if (position <= count + 1) {

			if (position == count + 1) {

				insertAtEnd(data);
			} else {
				for (int i = 2; i < position; i++) {
					temp = temp.next;
				}
				new_node.next = temp.next;
				temp.next.prev = new_node;
				temp.next = new_node;
				new_node.prev = temp;

				count++;
				// System.out.println(count);

			}
		} else {
			System.out.println("Position out of range");
		}

		return;
	}

	

	public void printList(Node node) {
		if (node == null)
			return;

		System.out.print(node.data + " ");

		printList(node.next);

	}

	public void printReverse() {
		Node temp = last;
		if (temp == null) {
			System.out.println("No elements to display");
			return;
		}
		while (temp != first) {
			System.out.print(temp.data + " ");
			temp = temp.prev;
		}
		System.out.print(temp.data);
		System.out.println();

	}

	public void deleteAtBeginning() {
		if (first == null && last == null) {
			System.out.println("No elements to delete");
			return;
		} else if (first == last) {
			System.out.println(first.data + " deleted");
			first = last = null;
		} else {
			Node temp = first;
			first = temp.next;
//			first.prev = null;
			System.out.println(temp.data + " deleted");
			temp = null;
			first.prev = null;
		}

		count--;
		// System.out.println(count);

		return;

	}

	public void deleteAtEnd() {
		if (first == null && last == null) {
			System.out.println("No elements to delete");
			return;

		} else if (first == last) {
			System.out.println(first.data + " deleted");
			first = last = null;
		} else {
			Node temp = last;
			System.out.println(temp.data + " deleted");
			temp.prev.next = null;
			last = temp.prev;
			temp.prev = null;

			temp = null;

			count--;
			// System.out.println(count);

			return;
		}

	}

	public void deleteAtSpecifiedPosition(int position) {
		Node temp = first;

		if (first == null) {
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
					temp = temp.next;
				}
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				System.out.println(temp.data + " deleted");
				temp = null;

				count--;

			}

		} else {
			System.out.println("Position out of range");
		}

		return;
	}

	

	public void search(int element) {
		Node temp = first;
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
}
