package com.pramati.learning.practise;

import java.util.Optional;

public class OptionalClassTest1 {
	public static void main(String[] args) {
		String words[] = new String[10];
		/*
		 * String word1 = words[2].toLowerCase(); System.out.println(word1);
		 */
		Optional<String> checkNull = Optional.ofNullable(words[2]);
		if (checkNull.isPresent()) {
			String word2 = words[2].toLowerCase();
			System.out.println(word2);
		} else {
			System.out.println("word is null");
		}

		String[] str = new String[5];

		str[2] = "Java is an OO technology";

		Optional<String> empty = Optional.empty();
		System.out.println(empty);

		Optional<String> value = Optional.of(str[2]);
		System.out.println(value);

		System.out.println(value.isPresent());
		System.out.println(value.hashCode());
		System.out.println(value.get());

		Optional<String> test = value.filter((e) -> e.equals("Java is an OO technology"));
		
		if (test.isPresent())
			System.out.println(test.get());

	}
}
