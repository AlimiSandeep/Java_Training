package com.pramati.learning.practise;

import java.util.Scanner;

public class PalindromeNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		
		PalindromeNumber palindrome=new PalindromeNumber();
		boolean res=palindrome.isPalindrome(num);
		
		if (res)
			System.out.println("Palindrome");
		else
			System.out.println("Not a Palindrome");

		in.close();
	}

	public boolean isPalindrome(int num) {
		int copy = num;
		int sum = 0, rem;
		while (num > 0) {
			rem = num % 10;
			sum = (sum * 10) + rem;
			num /= 10;

		}
		if (sum == copy)
			return true;

		return false;
	}
}
