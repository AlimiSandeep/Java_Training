package com.pramati.learning.practise.streams;

import java.util.*;

public class Temp {
	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("2019-05-01", 145);
		map.put("2019-05-02", 245);
		map.put("2019-05-03", 125);
		map.put("2019-05-04", 105);
		map.put("2019-05-05", 345);
		map.put("2019-05-06", 450);
		map.put("2019-05-07", 100);

		List<Integer> list = new ArrayList<Integer>();
		list.addAll(map.values());

		Collections.sort(list);

		int min = list.get(0);
		int max = list.get(list.size() - 1);

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (min == entry.getValue())
				System.out.println(entry.getKey() + " " + entry.getValue());
			if (max == entry.getValue())
				System.out.println(entry.getKey() + " " + entry.getValue());

		}

	}
}

/*
 * Scanner in = new Scanner(System.in); long num=in.nextLong(); int
 * rem,largest=-1; while(num>999) { rem=(int)num%10000; if(rem>largest)
 * largest=rem; num/=10; }
 * 
 * if(largest>-1) System.out.println(largest); else System.out.println("-1");
 */