package com.pramati.learning.multithreading;

public class ThreadPriority implements Runnable {

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName());

	}

	public static void main(String[] args) {
		ThreadPriority tp1 = new ThreadPriority();
		Thread t1 = new Thread(tp1);

		ThreadPriority tp2 = new ThreadPriority();
		Thread t2 = new Thread(tp2);

		ThreadPriority tp3 = new ThreadPriority();
		Thread t3 = new Thread(tp3);

		t1.setPriority(Thread.MIN_PRIORITY);
		t1.setName("First");
		t1.start();

		t2.setPriority(Thread.NORM_PRIORITY);
		t2.setName("Second");
		t2.start();

		t3.setPriority(Thread.MAX_PRIORITY);
		t3.setName("Third");
		t3.start();
	}

}
