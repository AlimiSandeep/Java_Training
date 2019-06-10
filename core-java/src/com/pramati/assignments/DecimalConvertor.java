package com.pramati.assignments;

public class DecimalConvertor {

	public static boolean areEqualByThreeDecimalPlaces(double a, double b) {
		a = a * 1000;
		b = b * 1000;
		if (a == b)
			return true;

		return false;

	}

	public static void main(String[] args) {
		System.out.println(DecimalConvertor.areEqualByThreeDecimalPlaces(-3.1756, -3.1756));
		System.out.println(DecimalConvertor.areEqualByThreeDecimalPlaces(3.175, 3.176));
		System.out.println(DecimalConvertor.areEqualByThreeDecimalPlaces(3.0, 3.0));
		System.out.println(DecimalConvertor.areEqualByThreeDecimalPlaces(-3.123, 3.123));
	}
}
