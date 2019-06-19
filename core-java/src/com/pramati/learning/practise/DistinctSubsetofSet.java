package com.pramati.learning.practise;

import java.util.HashSet;
import java.util.Set;

public class DistinctSubsetofSet {

	public static void distinctSubsets(int arr[]) {
		Set<String> set = new HashSet<>();

		for (int i = 0; i < Math.pow(2, arr.length); i++) {
			String subset = "( ";

			for (int j = 0; j < arr.length; j++) {
				//finding whether jth bit in i is present in set or not
				if ((i & (1 << j)) > 0) {
					subset += arr[j] + " ";
				}

			}

			set.add(subset + ")");
		}

		for(String str:set)
			System.out.println(str);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 1 };
		distinctSubsets(arr);
	}
}
