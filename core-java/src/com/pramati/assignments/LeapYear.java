package com.pramati.assignments;

public class LeapYear {
public static boolean isLeapYear(int year)
{
	if(year>=0 && year<=9999) {
	if(year%4==0)
	{
		if(year%100==0 && year%400!=0)
			return false;
		
		
		return true;
	}
}
	return false;
}
public static void main(String[] args) {
	System.out.println(LeapYear.isLeapYear(1700));
	System.out.println(LeapYear.isLeapYear(2000));
	System.out.println(LeapYear.isLeapYear(2400));
	System.out.println(LeapYear.isLeapYear(2600));
	System.out.println(LeapYear.isLeapYear(2100));
	System.out.println(LeapYear.isLeapYear(2016));
	System.out.println(LeapYear.isLeapYear(-1700));
	System.out.println(LeapYear.isLeapYear(2020));
	System.out.println(LeapYear.isLeapYear(1800));
}
}
