package com.leetCode;

import java.util.ArrayList;

public class E239_SlidingWindowMaximun {

	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		for (int i : maxSlidingWindow(nums, 3)) {
			System.out.println(i + " ");
		}

	}
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0) return new int[]{};
		int index = 0;
        for (int i = 1; i < nums.length && i < k; i++) {
        	index = nums[index] > nums[i] ? index : i;
        }
        //如果数组长度小于k，则返回全数组中最小的
        if (nums.length < k) return new int[] {nums[index]};
        
        int[] res = new int[nums.length - k + 1];
        res[0] = nums[index];
        for (int i = 1; i < nums.length - k + 1; i++) {
        	if (index >= i) {
        		 if (nums[index] <= nums[i+k-1]) {
        			 index = i+k-1;
        		 }
        	}
        	else {
        		index = i;
        		for (int j = i + 1; j < i + k; j++) {
        			index = nums[index] > nums[j] ? index : j;
        		}
        	}
        	res[i] = nums[index];
        }
        return res;
        
    }

}
