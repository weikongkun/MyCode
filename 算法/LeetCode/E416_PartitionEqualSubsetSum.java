package com.leetCode;

public class E416_PartitionEqualSubsetSum {
	int sum = 0;
	//背包
	public boolean canPartition(int[] nums) {
		int sum_nums = 0;
		for (int i = 0; i < nums.length; i++)
			sum_nums += nums[i];
		if ((sum_nums & 1) == 1) return false;
		int W = sum_nums / 2;
		boolean[] dp = new boolean[W + 1];
		dp[0] = true;
		for (int num : nums) {
			for (int i = W; i >= 0; i--) {
				if (num <= i) 
					dp[i] = dp[i] || dp[i - num];
			}
		}
		return dp[W];
		
    }
	
	//超时
	public boolean canPartition2(int[] nums) {
		for (int i = 0; i < nums.length; i++)
			sum += nums[i];
		if ((sum & 1) == 1) return false;
		sum /= 2;
		return backtracing(nums, 0, 0);
	}
	private boolean backtracing(int[] nums, int cur, int curSum) {
		if (cur == nums.length && curSum == sum) return true;
		if (curSum > sum || cur == nums.length) return false;
		if (backtracing(nums, cur + 1, curSum + nums[cur]))
			return true;
		if (backtracing(nums, cur + 1, curSum))
			return true;
		return false;
	}
}
