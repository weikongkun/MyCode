package com.Thread;

public class TestThreadLocal {
	private static int i = 0;
	private static ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
		protected Integer initialValue() {
			return i;
		}
	};
	static class Test implements Runnable{

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + "��ʼִ��");
			System.out.println(Thread.currentThread().getName() + " " + local.get());
			i++;
			System.out.println(Thread.currentThread().getName() + " " + local.get());
			System.out.println(Thread.currentThread().getName() + "ִ�����");
		}
		
	}
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			new Thread(new Test()).start();
		}
	}
}
