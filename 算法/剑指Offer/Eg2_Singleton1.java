package com.JianZhiOffer;

public class Eg2_Singleton1 implements Runnable {
	private static Eg2_Singleton1 instance = null;
	
	private Eg2_Singleton1() {
		
	}
	public static Eg2_Singleton1 getInstence() {
		return instance;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		if (instance == null) 
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			instance = new Eg2_Singleton1();
	}
	public String toString() {
		if (instance == null)
			return "null";
		else
			return "Singleton";
	}
	
}
