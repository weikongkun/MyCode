package com.leetCode;

public class E162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        int last = Integer.MIN_VALUE;
        int indexOfLast = -1;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] > last) {
        		last = nums[i];
        		indexOfLast  = i;
        	}
        	else if (nums[i] < last) return indexOfLast;
        }
        return nums.length - 1;
    }
}
