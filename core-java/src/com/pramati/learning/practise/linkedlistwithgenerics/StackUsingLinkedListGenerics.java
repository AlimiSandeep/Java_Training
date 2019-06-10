package com.pramati.learning.practise.linkedlistwithgenerics;

import java.util.Iterator;

import java.util.Objects;

public class StackUsingLinkedListGenerics<T> implements Iterable<T> {

	static int count = 0;
	public static final int size = 10;

	Node<T> first, top;

	class Node<V> {
		V data;
		Node<V> next;

		public Node(V data, Node<V> next) {
			super();
			this.data = data;
			this.next = next;

		}
	}

	public void push(T data) {
		if (count == size) {
			System.out.println("Stack overflow");
			return;
		} else if (top == null) {
			Node<T> temp = new Node<>(data, null);

			first = top = temp;

		} else {
			Node<T> temp = new Node<>(data, null);
			top.next = temp;
			top = temp;
		}
		count++;
		return;
	}

	public void display(Node<T> node) {
		if (node == null) {
			System.out.println("No elements to display");
			return;
		}
		display(node.next);
		System.out.print(node.data + " ");
	}

	boolean isEmpty() {
		return Objects.isNull(top);
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
			Node<T> temp = first;
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

	@Override
	public Iterator<T> iterator() {

		return new Iterator<T>() {
			Node<T> temp = first;

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return Objects.nonNull(temp);
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				T data = temp.data;
				temp = temp.next;
				return data;
			}
		};
	}
}
