package com.pramati.assignment.oop;

class Car_A {
	private int cylinders;
	String name;
	private boolean engine;
	private int wheels;

	public Car_A() {
		this.engine = true;
		this.wheels = 4;
	}

	public Car_A(String name, int cylinders) {
		super();
		this.cylinders = cylinders;
		this.name = name;
	}

	public int getCylinders() {
		return cylinders;
	}

	public String getName() {
		return name;
	}

	public boolean isEngine() {
		return engine;
	}

	public int getWheels() {
		return wheels;
	}

	public void startEngine() {
		if (engine)
			System.out.println("Engine started");
		else
			System.out.println("Engine off");
	}

	public void accelerate() {
		System.out.println("Accelerating....");

	}

	public void brake() {
		System.out.println("Stopping..");

	}
}

class Zen extends Car_A {

	@Override
	public void startEngine() {
		System.out.println("Zen engine started");
	}

}

class Swift extends Car_A {

	@Override
	public void startEngine() {
		System.out.println("Swift engine started");
	}

}

public class Polymorphism {
	public static void main(String[] args) {
		//Car_A car = new Car_A("XUV", 2);

		Zen zen = new Zen();
		zen.startEngine();
		

	}

}
