package com.leetCode;

import java.util.Arrays;

public class E45_JumpGameII {
	public static void main(String[] args) {
		E45_JumpGameII test = new E45_JumpGameII();
		int[] nums = {2,3,1,1,4};
		System.out.println(test.jump2(nums));
	}
	public int jump(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
				dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
				if (i + j == nums.length - 1) return dp[i + j];
			}
		}
		return dp[nums.length - 1];
	}
	public int jump2(int[] nums) {
		int lastReach = 0;
		int reach = 0;
		int step = 0;
		for (int i = 0; i <= reach && i < nums.length; i++) {
			if (i > lastReach) {
				step++;
				lastReach = reach;
			}
			reach = Math.max(reach, nums[i] + i);
		}
		if (reach < nums.length - 1) return 0;
		return step;
		
	}
}
