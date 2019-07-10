package com.pramati.learning.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class WorkerThread1 implements Callable<String> {
	private String message;
	boolean flag;

	public WorkerThread1(String message) {
		super();
		this.message = message;
		this.flag = true;
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(5);
		flag = false;
		return message;
	}

}

class WorkerThread2 implements Callable<String> {
	private String message;
	WorkerThread1 wt;

	public WorkerThread2(String message, WorkerThread1 wt) {
		super();
		this.message = message;
		this.wt = wt;
	}

	@Override
	public String call() throws Exception {
		while (this.wt.flag) {
			System.out.println("busy waiting...");
		}
		return message;
	}

}

public class BusySpinDemo {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		WorkerThread1 workerThread1 = new WorkerThread1("Hello....from worker Thread 1");
		Future<String> future1 = executorService.submit(workerThread1);
		Future<String> future2 = executorService
				.submit(new WorkerThread2("Hello....from worker Thread 2", workerThread1));
		executorService.shutdown();

		try {
			System.out.println(future1.get());
			System.out.println(future2.get());
		} catch (InterruptedException | ExecutionException e) {

			e.printStackTrace();
		}

	}
}
