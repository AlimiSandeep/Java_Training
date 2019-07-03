package com.pramati.learning.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable {
	private int taskNumber;

	public WorkerThread(int taskNumber) {
		super();
		this.taskNumber = taskNumber;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " executing task-" + taskNumber);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}

public class ExecutorSample {
	private static int nTasks=10;
	private static int nThreads=2;

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(nThreads);
System.out.println("Thread pool created with 2 threads");
		for (int i = 1; i <= nTasks; i++) {
			Runnable task = new WorkerThread(i);
			executor.execute(task);
		}
		executor.shutdown();
		System.out.println("Executor shutdown");
	}
}
