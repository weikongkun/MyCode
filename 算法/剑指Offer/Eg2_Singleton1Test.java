package com.JianZhiOffer;

public class Eg2_Singleton1Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Eg2_Singleton1 ex1 = Eg2_Singleton1.getInstence();
		Eg2_Singleton1 ex2 = Eg2_Singleton1.getInstence();
		System.out.println(ex1 == ex2);
		
		Thread thread1 = new Thread(ex1);
		Thread thread2 = new Thread(ex2);
		
		thread1.start();
		thread2.start();
		Eg2_Singleton1 ex3 = Eg2_Singleton1.getInstence();
		System.out.println(ex3);
	}

}
