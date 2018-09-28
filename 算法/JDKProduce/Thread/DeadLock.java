package com.Thread;
//用jps -lvm查看运行的java程序
//用jstack -l pid查看堆栈
public class DeadLock {
	private static String a = "a";
	private static String b = "b";
	public static void main(String[] args) {
		deadLock();
	}
	public static void deadLock() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (a) {
					System.out.println("get a");
					try {
						Thread.sleep(2000);
						synchronized (b) {
							System.out.println("get b");
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (b) {
					System.out.println("get b");
					try {
						Thread.sleep(2000);
						synchronized (a) {
							System.out.println("get a");
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		t1.start();
		t2.start();
	}
}
