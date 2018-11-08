package com.JUC;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	private CountDownLatch startGate;
	private CountDownLatch endGate;
	private int count;
	public CountDownLatchTest(int count) {
		this.count = count;
		startGate = new CountDownLatch(1);
		endGate = new CountDownLatch(count);
	}
	public void test() {
		System.out.println("线程同时启动");
		for (int i = 0; i < count; i++) 
			new Thread(new Work(startGate, endGate)).start();
		long start = System.nanoTime();
		startGate.countDown();
		try {
			endGate.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("线程全部执行结束");
		long end = System.nanoTime();
		System.out.println("执行时间：" + (end - start));
	}
	public static void main(String[] args) {
		CountDownLatchTest test = new CountDownLatchTest(5);
		test.test();
	}
}
class Work implements Runnable {
	private CountDownLatch startGate;
	private CountDownLatch endGate;
	public Work(CountDownLatch startGate, CountDownLatch endGate) {
		this.startGate = startGate;
		this.endGate = endGate;
	}
	@Override
	public void run() {
		try {
			System.out.println("线程" + Thread.currentThread().getName() + " 等待执行");
			startGate.await();
			int index = 0;
			while (index++ < 10000000);
			System.out.println("线程" + Thread.currentThread().getName() + " 结束执行");
			endGate.countDown();
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
