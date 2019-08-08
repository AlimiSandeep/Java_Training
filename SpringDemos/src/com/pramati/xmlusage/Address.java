package com.pramati.xmlusage;

public class Address {
	private int pin;
	private String state;
	private String country;

	public Address(int pin, String state, String country) {
		super();
		this.pin = pin;
		this.state = state;
		this.country = country;
	}

	@Override
	public String toString() {
		return pin + " " + state + " " + country;
	}

}
