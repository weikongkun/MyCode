package com.leetCode;

import java.util.Arrays;

public class E64_MinimumPathSum {
	public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)  return 0;
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        for (int i = 1; i <= m; i++) {
        	for (int j = 1; j <= n; j++) {
        		if (i == 1) dp[j] = dp[j - 1] + grid[i - 1][j - 1];
        		else if (j == 1) dp[j] += grid[i - 1][j - 1];
        		else dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i - 1][j - 1];
        	}
        }
        return dp[n];
    }
}
