package com.pramati.learning.practise;

import java.util.Scanner;

public class ArraySumTillSingleDigit {

	public int returnSum(int arr[]) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum += arr[i];

		return determineSum(sum);
	}

	public int determineSum(int num) {
		int rem, sum = 0;

		while (num > 0) {
			rem = num % 10;
			sum += rem;
			num /= 10;
		}
		if (sum >= 0 && sum <= 9)
			return sum;

		return determineSum(sum);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter array size");
		int size = in.nextInt();
		int arr[] = new int[size];

		for (int i = 0; i < size; i++)
			arr[i] = in.nextInt();

		ArraySumTillSingleDigit arraySumTillSingleDigit = new ArraySumTillSingleDigit();
		int sum = arraySumTillSingleDigit.returnSum(arr);
		System.out.println(sum);

		in.close();
	}

}
