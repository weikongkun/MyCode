package com.netease;

import java.util.Scanner;

import org.omg.PortableServer.ServantActivator;

public class Netease2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long lo = in.nextInt();
		long hi = in.nextInt();
		int count = 0;
//		int begin = (1 + lo) * lo / 2;
//		for (int i = lo; i <= hi; i++) {
//			if (begin % 3 == 0) count++;
//			begin = begin + i + 1;
//		}
		for (long i = lo; i <= hi; i++) {
			if ((((1 + i) * i) % 6) == 0) {
				count++;
			}
		}
		System.out.println(count);
	}
	
}
