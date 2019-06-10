package com.pramati.learning.practise;

import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the size of array:");
		int size = in.nextInt();
		System.out.println("Enter " + size + " elements:");
		int arr[] = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = in.nextInt();
		BubbleSort bsort = new BubbleSort();
		bsort.bubbleSort(arr, size);

		for (int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
		in.close();
	}

	public void bubbleSort(int arr[], int size) {
		int temp;
		boolean flag;
		for (int i = 0; i < size - 1; i++) {
			flag = false;
			for (int j = 0; j < size - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = true;

				}
			}
			if (!flag) {
				System.out.println("Terminated at " + (i + 1) + " pass");

				return;
			}
		}
		return;
	}

}
