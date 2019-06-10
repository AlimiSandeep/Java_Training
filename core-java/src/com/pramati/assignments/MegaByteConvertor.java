package com.pramati.assignments;

public class MegaByteConvertor {

	public static void printMegaBytesAndKiloBytes(int kiloBytes) {
		if (kiloBytes >= 0) {
			int megabytes = kiloBytes / 1024;
			int remKiloBytes = kiloBytes % 1024;
			System.out.println(kiloBytes + " KB = " + megabytes + " MB and " + remKiloBytes + " bytes");
		} else
			System.out.println("Invalid Value");
	}

	public static void main(String[] args) {
		MegaByteConvertor.printMegaBytesAndKiloBytes(2500);
		MegaByteConvertor.printMegaBytesAndKiloBytes(0);
		MegaByteConvertor.printMegaBytesAndKiloBytes(-2500);

	}
}
