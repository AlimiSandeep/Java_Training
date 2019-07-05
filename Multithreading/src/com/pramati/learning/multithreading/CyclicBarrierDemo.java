package com.pramati.learning.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class Computation1 implements Runnable {

	static int product = 0;

	@Override
	public void run() {

		product = 4 * 5;

		try {

			CyclicBarrierDemo.barrier.await();
		} catch (InterruptedException e) {

			e.printStackTrace();
		} catch (BrokenBarrierException e) {

			e.printStackTrace();
		}
	}

}

class Computation2 implements Runnable {

	static int sum = 0;

	@Override
	public void run() {

		sum = 4 + 5;
		System.out.println("Is barrier brocken ? " + CyclicBarrierDemo.barrier.isBroken());
		try {

			CyclicBarrierDemo.barrier.await(1000, TimeUnit.MILLISECONDS);

			System.out.println(CyclicBarrierDemo.barrier.isBroken());
			System.out.println(CyclicBarrierDemo.barrier.getNumberWaiting());
		} catch (InterruptedException e) {

			e.printStackTrace();
		} catch (BrokenBarrierException e) {

			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

public class CyclicBarrierDemo implements Runnable {
	static CyclicBarrier barrier = new CyclicBarrier(3);

	public static void main(String[] args) {
		CyclicBarrierDemo barrierDemo = new CyclicBarrierDemo();
		Thread t1 = new Thread(barrierDemo);
		t1.start();
	}

	@Override
	public void run() {
		System.out.println("Number of parties at the barrier currently " + barrier.getParties());

		System.out.println("Sum of product and sum is " + Computation1.product + Computation2.sum);

		Computation1 c1 = new Computation1();
		Thread t2 = new Thread(c1);
		Computation2 c2 = new Computation2();
		Thread t3 = new Thread(c2);

		t2.start();
		t3.start();

		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {

			e.printStackTrace();
		}
		System.out.println(CyclicBarrierDemo.barrier.isBroken());
		System.out.println(CyclicBarrierDemo.barrier.getNumberWaiting());
		System.out.println("Sum of product and sum is " + Computation1.product + Computation2.sum);
	
		barrier.reset();
		System.out.println("Barrier reset successful");
	
	}

}
