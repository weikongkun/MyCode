package com.leetCode;

public class E540_SingleElementInASortedArray {
	public static void main(String[] args) {
		int[] nums = {1, 1, 2};
		System.out.println(singleNonDuplicate(nums));
	}
	public static int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
        	int mid = l + (h - l) / 2;
        	if (nums[mid - 1] != nums[mid]) mid--;
        	if ((mid + 1) % 2 == 0) l = mid + 1;
        	else h = mid;
        }
        return nums[l];
    }
}
