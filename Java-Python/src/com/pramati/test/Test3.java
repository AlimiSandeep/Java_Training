package com.pramati.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import net.xdevelop.jpclient.PyExecutor;
import net.xdevelop.jpclient.PyResult;
import net.xdevelop.jpclient.PyServeContext;
import net.xdevelop.jpclient.PyServeException;

public class Test3 {

	public static void main(String[] args) {
		try {
			PyServeContext.init("localhost", 8888);
		} catch (PyServeException e) {
			e.printStackTrace();
		}
		PyExecutor executor = PyServeContext.getExecutor();
		File f=new File("demo1.py");
		PyResult rs = executor.exec(f);
//		System.out.println("Result: " + rs.getResult());

		
		try {

			ProcessBuilder pb = new ProcessBuilder("python3.6", "demo2.py", rs.getResult(),"get me details of sachin");
			Process p = pb.start();

			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));

			System.out.println(in.readLine());
			System.out.println(in.readLine());
			System.out.println(in.readLine());
			System.out.println(in.readLine());
			while (in.readLine() != null) {
				String ret = in.readLine();
				System.out.println("value is : " + ret);
			}

		} catch (Exception e) {
		}
	}
}
