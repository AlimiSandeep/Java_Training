package com.pramati.assignment.oop;

class Vehicle {

	int numOfGears;
	int Steering;
	int numOfSeats;

}

class Car extends Vehicle {
	int numOfSeats = 5;
	int numOfGears = 4;

	public void moving() {
		System.out.println("Moving.....");
	}

}

class XUV extends Car {

	int numOfSeats = 10;
	int numOfGears = 6;

	@Override
	public void moving() {
		System.out.println("Stopping..");
	}

}

public class Inheritance {
	public static void main(String[] args) {
		XUV xuv = new XUV();
		System.out.println(xuv.getClass().getSimpleName());
		System.out.println("Num of gears= " + xuv.numOfGears);
		System.out.println("Num of seats= " + xuv.numOfSeats);
		xuv.moving();

		Car car = new Car();
		System.out.println(car.getClass().getSimpleName());
		System.out.println("Num of gears= " + car.numOfGears);
		System.out.println("Num of seats= " + car.numOfSeats);
		car.moving();
	}
}
