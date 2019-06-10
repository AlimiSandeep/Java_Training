package com.pramati.assignments;

public class BarkingDog {

	public static boolean shouldWakeUp(boolean barking, int hourOfDay) {
		if (barking == true) {
			if ((hourOfDay >= 0 && hourOfDay < 8) || (hourOfDay > 22 && hourOfDay <= 23))
				return true;
		}

		return false;
	}

	public static void main(String[] args) {

		System.out.println(BarkingDog.shouldWakeUp(true, 1));
		System.out.println(BarkingDog.shouldWakeUp(false, 2));

		System.out.println(BarkingDog.shouldWakeUp(true, 8));

		System.out.println(BarkingDog.shouldWakeUp(true, -1));
		System.out.println(BarkingDog.shouldWakeUp(true, 0));
		System.out.println(BarkingDog.shouldWakeUp(true, 25));

	}
}
