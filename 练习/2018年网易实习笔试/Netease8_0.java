package com.netease;

import java.util.Arrays;
import java.util.Scanner;
//通过60%，其他运行超市
public class Netease8_0 {
	public static long res = 0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		long V = in.nextInt();
		long[] arr = new long[N];
		for (int i = 0; i < N; i++)
			arr[i] = in.nextInt();
		int[] temp = new int[N];
		Arrays.fill(temp, 1);
		solve(arr, temp, 0, V);
		System.out.println(res);
		in.close();
		
	}
	private static void solve(long[] arr, int[] temp, int cur, long V) {
		if (cur == arr.length) {
			long sum = 0;
			for (int i = 0; i < temp.length; i++)
				if (temp[i] == 1) sum += arr[i];
			if (sum <= V) res++;
			return;
		}
		temp[cur] = 1;
		solve(arr, temp, cur + 1, V);
		temp[cur] = 0;
		solve(arr, temp, cur + 1, V);
	}
}
