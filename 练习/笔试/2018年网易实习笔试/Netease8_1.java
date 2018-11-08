package com.netease;

import java.util.Arrays;
import java.util.Scanner;

//算法复杂度过大
public class Netease8_1 {

	public static long res = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		long V = in.nextInt();
		long[] arr = new long[N];
		for (int i = 0; i < N; i++)
			arr[i] = in.nextInt();
		int[] temp = new int[N];
		solve(arr, temp, 0, V);
		System.out.println(res);
		in.close();

	}

	private static void solve(long[] arr, int[] temp, int cur, long V) {
		long sum = 0;
		for (int i = 0; i < cur; i++)
			sum += arr[temp[i]];
		if (sum <= V) {
			res++;
			int s = 0;
			if (cur > 0)
				s = temp[cur - 1] + 1;
			for (int i = s; i < arr.length; i++) {
				temp[cur] = i;
				solve(arr, temp, cur + 1, V);
			}
		}

	}

}
