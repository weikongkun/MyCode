package com.Thread;

import java.util.Random;

public class TestYield {
	public static Random ran = new Random();
	static class Work implements Runnable {

		@Override
		public void run() {
			int k = ran.nextInt(5);
			try {
				Thread.sleep(k * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "ִ����ϣ�ʱ�䣺" + k);
		}
		
	}
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new Work()).start();
		}
		//���л�����һ�����߳�
		while (Thread.activeCount() > 1) {
			Thread.yield();
		}
		System.out.println("���ж�ִ����ϣ�����");
	}
}
