package com.leetCode;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0, 2, 1, -3};
		System.out.println(threeSumClosest1(nums, 1));
	}
	public static int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(res - target);
        for (int i = 0; i < nums.length - 2; i++) {
        	int lo = i + 1, hi = nums.length - 1;
        	while (hi > lo) {
        		int sum = nums[i] + nums[lo] + nums[hi];
        		if (Math.abs(sum - target) < diff) {
        			res = sum;
        			diff = Math.abs(sum - target);
        		}
        		
        		if (sum < target) 
        			lo++;
        		else
        			hi--;
        			
        	}
            
        }
        return res;
        
	}
}
