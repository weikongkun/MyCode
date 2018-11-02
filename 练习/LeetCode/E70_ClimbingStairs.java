package com.leetCode;

import java.util.Currency;

public class E70_ClimbingStairs {	
	public int climbStairs(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		if (n == 2) return 2;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < arr.length; i++)
        	arr[i] = arr[i - 1] + arr[i - 2];
        return arr[n];
    }
	public int climbStairs2(int n) {
		if (n <= 2) return n;
		int pre2 = 1, pre1 = 2;
		int cur = 0;
		for (int i = 3; i <= n; i++) {
			cur = pre2 + pre1;
			pre2 = pre1;
			pre1 = cur;
		}
		return cur;
	}
}
