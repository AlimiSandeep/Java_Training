package com.pramati.learning.practise;

public class LongestPalindromeInString {
	public static void main(String[] args) {
		LongestPalindromeInString obj = new LongestPalindromeInString();
		System.out.println(obj.findLongest("banana"));
	}

	public String findLongest(String str) {
		if (str.isEmpty())
			return "Please enter string";
		if (str.length() == 1)
			return str;

		String longest = str.substring(0, 1);

		for (int i = 0; i < str.length(); i++) {

			String tmp = equalityCheck(str, i, i);
			//System.out.println(tmp);
			if (tmp.length() > longest.length())
				longest = tmp;

			tmp = equalityCheck(str, i, i + 1);
			//System.out.println(tmp);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}

		}

		return longest;
	}

	public String equalityCheck(String str, int begin, int end) {
		while (begin >= 0 && end <= str.length() - 1 && str.charAt(begin) == str.charAt(end)) {
			begin--;
			end++;
		}
		// System.out.println(begin + 1 + " " + end);
		return str.substring(begin + 1, end);
	}
}
