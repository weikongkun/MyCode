package com.leetCode;

public class E153_FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
        	int mid = l + (h - l) / 2;
        	if (nums[mid] < nums[nums.length - 1]) h = mid;
        	else l = mid + 1;
        }
        return nums[l];
    }
}
