package com.pramati.assignments;

public class TeenNumberChecker {

	public static boolean hasTeen(int age1, int age2, int age3) {
		if (isTeen(age1) || isTeen(age2) || isTeen(age3))
			return true;

		return false;
	}

	public static boolean isTeen(int age) {
		if (age >= 13 && age <= 19)
			return true;

		return false;
	}

	public static void main(String[] args) {
		System.out.println(hasTeen(9, 99, 19));
		System.out.println(hasTeen(23, 15, 42));
		System.out.println(hasTeen(22, 23, 34));
		System.out.println(hasTeen(9, 12, 19));
	}
}
