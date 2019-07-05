package com.pramati.learning.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class IntegerSum implements Callable<Integer> {

	private Integer num;

	public IntegerSum(Integer num) {
		super();
		this.num = num;
	}

	@Override
	public Integer call() throws Exception {
		Integer sum = 0;
		for (int i = 1; i <= num; i++) {
			sum += i;
		}
		return sum;
	}

}

class DoubleMul implements Callable<Double> {

	private Double num;

	public DoubleMul(Double num) {
		this.num = num;
	}

	@Override
	public Double call() throws Exception {

		return num * num;
	}

}

public class CallableInterfaceDemo {

	private static int nThreads = 2;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(nThreads);
		Future<Integer> futureSum = executor.submit(new IntegerSum(5));
		Future<Double> futureDouble = executor.submit(new DoubleMul(6.5));
		System.out.println("IntegerSum has returned " + futureSum.get());
		System.out.println("DoubleMul has returned " + futureDouble.get());

		executor.shutdown();

	}
}
