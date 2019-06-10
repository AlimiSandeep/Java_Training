package com.pramati.learning.practise;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapDemo {
	public static void main(String[] args) {

		List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11, 13);

		List<Integer> OddNumbers = Arrays.asList(1, 3, 5);

		List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);

		List<List<Integer>> listOfListofInts = Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);

		System.out.println("The Structure before flattening is : " + listOfListofInts);

		// Using flatMap for transforming and flattening.
		List<Integer> listofInts = listOfListofInts.stream().flatMap(list -> list.stream())
				.collect(Collectors.toList());

		System.out.println("The Structure after flattening is : " + listofInts);

		List<List<String>> list = Arrays.asList(Arrays.asList("a"), Arrays.asList("b"));
		System.out.println(list);
		
		List<String> temp=list.stream().flatMap(Collection::stream).collect(Collectors.toList());
		
		System.out.println(temp);

	}
}
