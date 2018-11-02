package com.leetCode;

public class E413_ArithmeticSlices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int numberOfArithmeticSlices(int[] A) {
		if (A == null && A.length <= 2) return 0;
		int[] dp = new int[A.length];
		for (int i = 2; i < A.length; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2])
				dp[i] = dp[i - 1] + 1;
		}
		int res = 0;
		for (int i : dp) {
			res += i;
		}
		return res;
    }

}
