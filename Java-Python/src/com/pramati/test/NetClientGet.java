package com.pramati.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetClientGet {
	public static void main(String[] args) {
		try {
			String x = "get all doctors";
			String y = x.trim().replace(" ", "%20");
			URL url = new URL("http://127.0.0.1:5000/getintent/" + y);// your url i.e fetch data from .
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
			}
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			String intent;
			System.out.println(br.readLine());
//			while ((intent = br.readLine()) != null) {
//				System.out.println(intent);
//			}
			conn.disconnect();

		} catch (Exception e) {
			System.out.println("Exception in NetClientGet:- " + e);
		}
	}
}