package com.pramati.learning.multithreading;

public class ThreadSleep extends Thread {

	@Override
	public void run() {

		for (int i = 0; i < 50; i++) {
			try {

				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i +" "+ Thread.currentThread().getName());
		}

	}

	public static void main(String[] args) {
		ThreadSleep ts = new ThreadSleep();
		ts.start();

		ThreadSleep ts1 = new ThreadSleep();
		ts1.start();

	}
}
