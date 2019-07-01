package com.pramati.learning.multithreading;



class Sample1 extends Thread { 
public void run() 
    { 
        synchronized(this) 
        { 
            System.out.println 
            (Thread.currentThread().getName() + "...starts"); 
            try { 
                this.wait(); 
            } 
            catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
            System.out.println 
            (Thread.currentThread().getName() + "...notified"); 
        } 
    } 
} class Sample2 extends Thread { 
    Sample1 sample1; 
    Sample2(Sample1 sample1) 
    { 
        this.sample1 = sample1; 
    } 
public void run() 
    { 
        synchronized(this.sample1) 
        { 
            System.out.println 
            (Thread.currentThread().getName() + "...starts"); 
  
            try { 
                this.sample1.wait(); 
            } 
            catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
            System.out.println 
            (Thread.currentThread().getName() + "...notified"); 
        } 
    } 
} class Sample3 extends Thread { 
    Sample1 sample1; 
    Sample3(Sample1 sample1) 
    { 
        this.sample1 = sample1; 
    } 
public void run() 
    { 
        synchronized(this.sample1) 
        { 
            System.out.println 
            (Thread.currentThread().getName() + "...starts"); 
  
            this.sample1.notify(); 
            System.out.println 
            (Thread.currentThread().getName() + "...notified"); 
        } 
    } 
} 
public class Notify_NotifyAll { 
public static void main(String[] args) throws InterruptedException 
    { 
  
        Sample1 sample1 = new Sample1(); 
        Sample2 sample2 = new Sample2(sample1); 
        Sample3 sample3 = new Sample3(sample1); 
        Thread t1 = new Thread(sample1, "Thread-1"); 
		Thread t2 = new Thread(sample2, "Thread-2"); 
        Thread t3 = new Thread(sample3, "Thread-3"); 
        t1.start(); 
        t2.start(); 
        Thread.sleep(100); 
        t3.start(); 
    } 
} 