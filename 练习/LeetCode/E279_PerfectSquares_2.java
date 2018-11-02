package com.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class E279_PerfectSquares_2 {
	//动态规划
	public static void main(String[] args) {
		System.out.println(numSquares(12));
	}
	public static int numSquares(int n) {
		int[] arr = new int[n + 1];
		arr[1] = 1;
		for (int i = 2; i <= n; i++) {
			if (isSquareNum(i)) {
				arr[i] = 1;
				continue;
			}
			List<Integer> list = new ArrayList<>();
			for (int j = 1; j <= i / 2; j++) {
				list.add(arr[j] + arr[i - j]);
			}
			arr[i] = Collections.min(list);
		}
		return arr[n];
	}
	public static boolean isSquareNum(int n) {
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if(i * i == n) return true;
		}
		return false;
	}
}
