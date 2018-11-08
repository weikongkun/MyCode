package com.netease;

import java.util.Scanner;

import org.omg.PortableServer.ServantActivator;

public class Netease3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		
		for (int i = 0; i < k; i++) {
			int length = in.nextInt();
			String str = in.next();
			int count = 0;
			int j = 0;
			while (j < str.length()) {
				if (str.charAt(j) == '.') {
					j += 3;
					count++;
				}
				else j++;
			}
			System.out.println(count);
		}
	}
}
