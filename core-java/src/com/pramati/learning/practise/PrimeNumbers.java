package com.pramati.learning.practise;

import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a positive number");
		int num = in.nextInt();
		if (num > 0) {
			for (int i = 2; i <= num; i++) {
				if (isPrime(i))
					System.out.print(i + " ");
			}
		} else
			System.out.println("Number should be greater than zero");

		in.close();
	}

	static boolean isPrime(int number) {
		int count = 0;
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0)
				count++;

		}
		if (count == 0)
			return true;

		return false;
	}

}
