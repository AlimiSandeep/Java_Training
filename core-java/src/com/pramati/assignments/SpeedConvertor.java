package com.pramati.assignments;

public class SpeedConvertor {

	public static long toMilesPerHour(double kilometersPerHour) {
		if (kilometersPerHour < 0)
			return -1;
		else {
			return (Math.round(kilometersPerHour / 1.609));
		}
	}

	public static void printConversion(double kilometersPerHour) {
		if (kilometersPerHour < 0)
			System.out.println("Invalid value");
		else {
			long milesPerHour = toMilesPerHour(kilometersPerHour);
			System.out.println(kilometersPerHour + " km/h= " + milesPerHour + " mi/h");
		}
	}

	public static void main(String[] args) {
		printConversion(1.5);
		printConversion(10.25);
		printConversion(-1.56);
		printConversion(25.42);
		printConversion(75.114);
	}
}