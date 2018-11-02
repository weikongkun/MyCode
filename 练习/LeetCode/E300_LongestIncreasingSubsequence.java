package com.leetCode;


public class E300_LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int[] dp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j])
					max = Math.max(max, dp[j]);
			}
			nums[i] = max + 1;
		}
		for (int j : dp) {
			System.out.println(j);
		}

		return maxOfArr(dp);
    }
	public int maxOfArr(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int i : nums) {
			max = Math.max(max, i);
		}
		return max;
	}
}
