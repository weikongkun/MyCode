package com.leetCode;

public class E494_TargetSum {
	//DFS
	public int findTargetSumWays(int[] nums, int S) {
	    return findTargetSumWays(nums, 0, S);
	}

	private int findTargetSumWays(int[] nums, int start, int S) {
	    if (start == nums.length) return S == 0 ? 1 : 0;
	    return findTargetSumWays(nums, start + 1, S + nums[start]) + findTargetSumWays(nums, start + 1, S - nums[start]);
	}

	//背包
	private int findTargetSumWays2(int[] nums, int s) {
		int sum = 0 ;
		for (int i = 0; i < nums.length; i++) 
			sum += nums[i];
		if (sum < s || (sum + s) % 2 == 1) return 0;
		int W = (sum + 2) / 2;
		int[] dp = new int[W + 1];
		dp[0] = 1;
		for (int num : nums) {
			for (int i = W; i >= 0; i--) 
				if (num <= i)
					dp[i] = dp[i] + dp[i - num];
		}
		return dp[W];
	}
}
