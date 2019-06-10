package com.pramati.assignments;

public class EqualSum {
public static boolean hasEqualSum(int a,int b,int c)
{
	if((a+b)==c)
		return true;
	return false;
}


public static void main(String[] args) {
	System.out.println(EqualSum.hasEqualSum(1, 1, 1));
	System.out.println(EqualSum.hasEqualSum(1, 1, 2));
	System.out.println(EqualSum.hasEqualSum(1, -1, 0));
	System.out.println(EqualSum.hasEqualSum(1234, 234, 1468));
}
}
