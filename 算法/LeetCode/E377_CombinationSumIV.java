package com.leetCode;

import java.util.Arrays;

public class E377_CombinationSumIV {
	//完全背包
	public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return target == 0 ? 1 : 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
        	for (int num : nums) {
				if (num <= i) 
					dp[i] = dp[i] + dp[i - num];
			}
        }
        return dp[target];
    }
}
