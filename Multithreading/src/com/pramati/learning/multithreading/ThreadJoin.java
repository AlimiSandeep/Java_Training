package com.pramati.learning.multithreading;

public class ThreadJoin extends Thread {

	@Override
	public void run() {
		super.run();

		for (int i = 1; i <= 10; i++) {

			try {
				Thread.sleep(500);
				System.out.println(i + " " + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ThreadJoin t1 = new ThreadJoin();
		ThreadJoin t2 = new ThreadJoin();
		ThreadJoin t3 = new ThreadJoin();

		t1.start();

		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t2.start();
		t3.start();
	}
}
