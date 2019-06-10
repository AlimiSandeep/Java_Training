package com.pramati.learning.practise;

import java.util.Scanner;

public class LinearSearch {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int size = in.nextInt();
		System.out.println("Enter " + size + " elements:");
		int arr[] = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = in.nextInt();
		System.out.println("Enter element to be searched:");
		int key = in.nextInt();

		LinearSearch lSearch = new LinearSearch();
		int index = lSearch.linearSearch(arr, size, key);
		if (index >= 0)
			System.out.println("Element " + key + " found at " + index + " position");
		else
			System.out.println("Element " + key + " not found");

		in.close();
	}

	public int linearSearch(int arr[], int size, int key) {
		for (int i = 0; i < size; i++) {
			if (arr[i] == key)
				return i + 1;
		}

		return -1;
	}
}
