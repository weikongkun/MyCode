package com.leetCode;

public class E213_HouseRobberII {
	private int[] dp;

	public int rob(int[] nums) {
	    if (nums == null || nums.length == 0) return 0;
	    int n = nums.length;
	    if (n == 1) return nums[0];
	    dp = new int[n];
	    return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
	}

	private int rob(int[] nums, int first, int last) {
	    if (last - first == 0) return nums[first];
	    if (last - first == 1) return Math.max(nums[first], nums[first + 1]);
	    dp[first] = nums[first];
	    dp[first + 1] = nums[first + 1];
	    dp[first + 2] = nums[first] + nums[first + 2];
	    for (int i = first + 3; i <= last; i++) {
	        dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
	    }
	    return Math.max(dp[last], dp[last - 1]);
	}
}
