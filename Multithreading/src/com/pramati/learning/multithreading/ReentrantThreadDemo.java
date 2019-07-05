package com.pramati.learning.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.concurrent.locks.ReentrantLock;

class Counter {
	private int counter = 0;

	ReentrantLock lock = new ReentrantLock();

	public int incrementCounter() {
		System.out.println("Is lock acquired by any thread " + lock.isLocked());
		System.out.println("Is locked by curret thread " + lock.isHeldByCurrentThread());
		boolean isAcquired = lock.tryLock();
		System.out.println("Lock Acquired : " + isAcquired + "\n");

		if (isAcquired) {
			try {
				Thread.sleep(2000);
				counter += 1;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		return counter;
	}
}

public class ReentrantThreadDemo {
	public static void main(String[] args) {
		int nThreads = 2;
		ExecutorService executorService = Executors.newFixedThreadPool(nThreads);

		Counter counter = new Counter();
		executorService.submit(() -> {
			System.out.println("IncrementCount (First Thread) : "+counter.incrementCounter() );
		});
		executorService.submit(() -> {
			System.out.println("IncrementCount (Second Thread) : "+counter.incrementCounter() );
		});

		executorService.shutdown();
	}
}
