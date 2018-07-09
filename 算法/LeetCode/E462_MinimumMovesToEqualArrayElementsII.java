package com.leetCode;

import java.util.Arrays;

public class E462_MinimumMovesToEqualArrayElementsII {
	public int minMoves2(int[] nums) {
		if (nums == null || nums.length <= 1) return 0;
        Arrays.sort(nums);;
        int res = 0;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
        	res = res + nums[hi] - nums[lo];
        	lo++;
        	hi--;
        }
        return res;
    }
}
