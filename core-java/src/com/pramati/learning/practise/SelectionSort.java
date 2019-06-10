package com.pramati.learning.practise;

import java.util.Scanner;

public class SelectionSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int size = in.nextInt();
		System.out.println("Enter " + size + " elements:");
		int arr[] = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = in.nextInt();

		SelectionSort sSort = new SelectionSort();

		sSort.selectionSort(arr, size);

		for (int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");

		in.close();
	}

	public void selectionSort(int arr[], int size) {
		int temp;
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return;
	}
}
