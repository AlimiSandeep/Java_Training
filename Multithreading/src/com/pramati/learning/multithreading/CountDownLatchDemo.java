package com.pramati.learning.multithreading;

import java.util.concurrent.CountDownLatch;

class Worker extends Thread {
	private int delay;
	private CountDownLatch latch;
	private String name;

	public Worker(int delay, CountDownLatch countDownLatch, String name) {
		super();
		this.delay = delay;
		this.latch = countDownLatch;
		this.name = name;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(delay);
			latch.countDown();
			System.out.println(name + " finished");
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
	}

}

public class CountDownLatchDemo {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(5);

		Worker first = new Worker(1000, latch, "Thread-1");
		Worker second = new Worker(2000, latch, "Thread-2");
		Worker third = new Worker(3000, latch, "Thread-3");
		Worker fourth = new Worker(4000, latch, "Thread-4");
		Worker fifth = new Worker(5000, latch, "Thread-5");

		first.start();
		second.start();
		third.start();
		fourth.start();
		fifth.start();

		latch.await();

		System.out.println(Thread.currentThread().getName() + " has finished");
	}
}
