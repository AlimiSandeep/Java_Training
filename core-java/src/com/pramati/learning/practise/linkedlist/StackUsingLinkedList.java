package com.pramati.learning.practise.linkedlist;

public class StackUsingLinkedList {

	static int count = 0;
	public static final int size = 10;

	Node first, top;

	class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			super();
			this.data = data;
			this.next = next;

		}
	}

	public void push(int data) {
		if (count == size) {
			System.out.println("Stack overflow");
			return;
		} else if (top == null) {
			Node temp = new Node(data, null);

			first = top = temp;

		} else {
			Node temp = new Node(data, null);
			top.next = temp;
			top = temp;
		}
		count++;
		return;
	}

	public void display(Node node) {
		if (node == null) {
			System.out.println("No elements to display");
			return;
		}
		display(node.next);
		System.out.print(node.data+" ");
	}

	public void peek() {
		if (count == 0 || top == null) {
			System.out.println("Stack underflow");
			return;
		} else {
			System.out.println(top.data);
		}
	}

	public void pop() {

		if (count == 0 || top == null) {
			System.out.println("Stack underflow");
			return;
		} else if (first == top) {
			System.out.println(top.data + " deleted from stack");
			top = first = null;

		} else {
			Node temp = first;
			while (temp.next != top) {
				temp = temp.next;
			}
			System.out.println(top.data + " deleted from stack");
			temp.next = null;
			top = null;
			top = temp;
		}
		count--;
		return;

	}

}
