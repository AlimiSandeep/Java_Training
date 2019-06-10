package com.pramati.learning.practise.linkedlistwithgenerics;

public class QueueUsingLinkedListGenerics<T> {

	Node<T> front;
	Node<T> rear;
	public static final int size = 4;
	static int count = 0;

	class Node<V> {
		V data;
		Node<V> next;

		public Node(V data, Node<V> next) {
			super();
			this.data = data;
			this.next = next;

		}
	}

	public void insert(T data) {
		if (count == size) {
			System.out.println("Queue overflow");
			return;
		} else {
			Node<T> new_node = new Node<T>(data, null);
			if (front == null && rear == null) {
				front = rear = new_node;
			} else {
				rear.next = new_node;
				rear = new_node;
			}

		}
		count++;
		return;

	}

	public void remove() {
		if (count == 0 || front == null) {
			System.out.println("Queue underflow");
			return;
		} else if (front == rear) {
			System.out.println(front.data + " deleted from queue");
			front = rear = null;
		} else {
			Node<T> temp = front;
			front = front.next;
			temp.next = null;
			System.out.println(temp.data + " deleted from queue");
			temp = null;

		}
		count--;
		return;

	}

	public void peek() {
		System.out.println("Top element " + rear.data);
		return;

	}

	public void display() {
		if (front == null || count == 0) {
			System.out.println("No elements to display");
			return;
		} else {
			Node<T> temp = front;
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
			System.out.println();
		}

		return;

	}

}
