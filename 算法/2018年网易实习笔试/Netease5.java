package com.netease;

import java.util.Scanner;

public class Netease5 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		if (k == 0) {
			System.out.println(n * n);
			return;
		}
		long count = 0;
		
		for (int y = k + 1; y <= n; y++) {
			int p = n / y;
			int N = ((n%y >= k) ? n%y-k+1 : 0);
			count = count + p *(y - k) + N;
		}
		
		System.out.println(count);
	}
}
