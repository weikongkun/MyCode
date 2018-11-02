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
		System.out.println("�߳�ͬʱ����");
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
		System.out.println("�߳�ȫ��ִ�н���");
		long end = System.nanoTime();
		System.out.println("ִ��ʱ�䣺" + (end - start));
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
			System.out.println("�߳�" + Thread.currentThread().getName() + " �ȴ�ִ��");
			startGate.await();
			int index = 0;
			while (index++ < 10000000);
			System.out.println("�߳�" + Thread.currentThread().getName() + " ����ִ��");
			endGate.countDown();
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
