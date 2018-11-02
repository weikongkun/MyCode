package com.leetCode;

import java.util.Arrays;

public class E376_WiggleSubsequence {
	public int wiggleMaxLength(int[] nums) {
	    int len = nums.length;
	    if (len == 0) return 0;
	    int up = 1, down = 1;
	    for (int i = 1; i < len; i++) {
	        if (nums[i] > nums[i - 1]) up = down + 1;
	        else if (nums[i] < nums[i - 1]) down = up + 1;
	    }
	    return Math.max(up, down);
	}
}
