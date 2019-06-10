package com.pramati.assignments;

import java.util.Scanner;

public class ArraysAssignment {

	public int[] getIntegers() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter array size");
		int size = in.nextInt();
		System.out.println("Enter " + size + " elements:");
		int array[] = new int[size];
		for (int i = 0; i < size; i++)
			array[i] = in.nextInt();

		in.close();
		return array;

	}

	public void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	public int[] sortIntegers(int[] arr) {
		int temp;
		boolean flag;
		int new_arr[] = new int[arr.length];

		for (int i = 0; i < arr.length; i++)
			new_arr[i] = arr[i];
		
		for (int i = 0; i < new_arr.length - 1; i++) {
			flag = false;
			for (int j = 0; j < new_arr.length - i - 1; j++) {
				if (new_arr[j] < new_arr[j + 1]) {
					temp = new_arr[j];
					new_arr[j] = new_arr[j + 1];
					new_arr[j + 1] = temp;
					flag = true;

				}
			}
			if (!flag) {
				break;
			}
		}
		return new_arr;
	}

	public static void main(String[] args) {
		ArraysAssignment obj = new ArraysAssignment();
		int array[] = obj.getIntegers();
		int new_arr[] = obj.sortIntegers(array);
//		obj.printArray(array);
		obj.printArray(new_arr);

	}
}
