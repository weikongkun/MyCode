package com.leetCode;

public class E343_IntegerBreak {
	public int integerBreak(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
        	int max = 0;
        	for (int j = 1; j < i; j++) {
        		dp[i] = Math.max(dp[i],  Math.max(j * dp[i - j], j * (i - j)));
        	}
        }
        return dp[n + 1];
    }
}
