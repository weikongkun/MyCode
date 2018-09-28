package com.Thread;

public class TestJoin {
	public static void main(String[] args) {
		testTwo();
	}
	private static void testOne() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("T1  执行完毕!");
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					t1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("T2  执行完毕!");
			}
		});
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					t2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("T3 执行完毕!");
			}
		});
		t1.start();
		t2.start();
		t3.start();
		System.out.println("运行结束");
	}
	private static void testTwo() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("T1  执行完毕!");
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("T2  执行完毕!");
			}
		});
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("T3 执行完毕!");
			}
		});
		try {
			t3.start();
			t3.join();
			t2.start();
			t2.join();
			t1.start();
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("运行结束");
	}
}
