package com.pramati.learning.practise;

import java.util.Scanner;

public class PrintingContentInBox {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int size = 0;
		System.out.println("How many inputs?");
		size = Integer.parseInt(in.nextLine());
		String[] inputs = new String[size];
		System.out.println("Enter words");
		for (int i = 0; i < size; i++) {
			inputs[i] = in.nextLine();
		}

		int maxsize = 0;

		for (String s : inputs) {
			if (s.length() > maxsize) {
				maxsize = s.length();
			}
		}

		for (int i = 0; i <= maxsize + 4; i++) {
			System.out.print("*");
		}

		System.out.println();
		for (int j = 0; j < inputs.length; j++) {

			if(inputs[j].length()%2==0) {
			System.out.print("*");
			for (int k = 0; k <= (maxsize - inputs[j].length()) / 2; k++)
				System.out.print(" ");
			System.out.print(inputs[j]);

			for (int k = 0; k <= ((maxsize - inputs[j].length()) / 2)+2; k++)
				System.out.print(" ");

			System.out.print("*");
			System.out.println();

		}
			else
			{
				System.out.print("*");
				for (int k = -1; k <= (maxsize - inputs[j].length()) / 2; k++)
					System.out.print(" ");
				System.out.print(inputs[j]);

				for (int k = 0; k <= (maxsize - inputs[j].length()) / 2; k++)
					System.out.print(" ");

				System.out.print("*");
				System.out.println();
			}
		}

		
		
		
		for (int i = 0;i <= maxsize + 4; i++) {
			System.out.print("*");
		}

		System.out.println();
		in.close();
	}
}

