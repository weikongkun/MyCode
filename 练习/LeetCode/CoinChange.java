package com.leetCode;

import java.util.Arrays;
public class CoinChange {
	//完全背包
	public int coinChange(int[] coins, int amount) {
	    if (coins == null || coins.length == 0) return 0;
	    int[] dp = new int[amount + 1];
	    Arrays.fill(dp, amount + 1);
	    dp[0] = 0;
	    for (int i = 1; i <= amount; i++) {
	        for (int c : coins) { // 硬币可以使用多次
	            if (c <= i) {
	                dp[i] = Math.min(dp[i], dp[i - c] + 1);
	            }
	        }
	    }
	    return dp[amount] > amount ? -1 : dp[amount];
	}
}
