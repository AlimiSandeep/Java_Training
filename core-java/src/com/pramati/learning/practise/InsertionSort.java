package com.pramati.learning.practise;

import java.util.Scanner;

public class InsertionSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int size = in.nextInt();
		System.out.println("Enter " + size + " elements:");
		int arr[] = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = in.nextInt();

		InsertionSort iSort = new InsertionSort();
		iSort.insertionSort(arr, size);

		for (int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");

		in.close();
	}

	public void insertionSort(int arr[], int size) {
		int key, j;
		for (int i = 1; i < size; i++) {
			key = arr[i];
			j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
		return;
	}
}
