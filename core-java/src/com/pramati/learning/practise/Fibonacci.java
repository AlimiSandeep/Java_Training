package com.pramati.learning.practise;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a positive number");
		int num = in.nextInt();
		int f1 = 0, f2 = 1, f3;
		if (num == 1)
			System.out.print(f1);
		else if (num == 2)
			System.out.print(f1 + " " + f2);
		else {
			System.out.print(f1 + " " + f2);
			for (int i = 3; i <= num; i++) {
				f3 = f1 + f2;
				System.out.print(" " + f3);
				f1 = f2;
				f2 = f3;

			}
		}
		in.close();
	}

}
