package com.pramati.learning.practise;

import java.util.Scanner;

public class PalindromeString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string");
		String str = in.next().trim();
		PalindromeString palindrome = new PalindromeString();
		boolean res = palindrome.isPalindrome(str);
		if (res)
			System.out.println("Palindrome");
		else
			System.out.println("Not a Palindrome");

		in.close();
	}

	public boolean isPalindrome(String str) {
		String temp = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			temp += str.charAt(i);
		}
		if (temp.equalsIgnoreCase(str))
			return true;

		return false;
	}
}
