package com.pramati.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test1 {

	public static void main(String a[]) {
		try {

//			ProcessBuilder pb = new ProcessBuilder("python3.6", "test1.py", "get me details of sachin");
			ProcessBuilder pb = new ProcessBuilder("python3.6", "/home/sandeepa/My Data/source_code/restflask.py");
			Process p = pb.start();

			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));

			while (in.readLine() != null) {
				String ret = in.readLine();
				System.out.println("value is : " + ret);
			}

		} catch (Exception e) {
		}
	}
}
