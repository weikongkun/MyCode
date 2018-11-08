package com.Thread;

public class TestJoin {
	public static void main(String[] args) {
		testTwo();
	}
	private static void testOne() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("T1  ִ�����!");
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
				System.out.println("T2  ִ�����!");
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
				System.out.println("T3 ִ�����!");
			}
		});
		t1.start();
		t2.start();
		t3.start();
		System.out.println("���н���");
	}
	private static void testTwo() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("T1  ִ�����!");
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("T2  ִ�����!");
			}
		});
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("T3 ִ�����!");
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
		System.out.println("���н���");
	}
}
