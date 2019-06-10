package com.pramati.learning.practise;

import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int size = in.nextInt();
		System.out.println("Enter " + size + " elements in ascending order:");
		int arr[] = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = in.nextInt();
		System.out.println("Enter element to be searched:");
		int key = in.nextInt();
		BinarySearch bSearch = new BinarySearch();
		bSearch.binarySearch(arr, size, key);

		in.close();

	}

	public void binarySearch(int arr[], int size, int key) {
		int low = 0, high = size - 1, mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] == key) {
				System.out.println("Element " + key + " found at " + (mid + 1) + " position");
				return;
			} else if (key > arr[mid])

				low = mid + 1;

			else
				high = mid - 1;
		}
		System.out.println("Element " + key + " not found");
		return;
	}

}
