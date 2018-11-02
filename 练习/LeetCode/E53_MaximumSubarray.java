package com.leetCode;

public class E53_MaximumSubarray {
	public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] < 0) {
        		max = Math.max(max, nums[i]);
        		sum = nums[i];
        	}
        	else {
        		if (sum < 0) {
        			max = Math.max(nums[i], max);
        			sum = nums[i];
        		}else {
        			sum += nums[i];
        			max = Math.max(sum, max);
        		}
        	}
        }
        return max;
    }
	public int maxSubArray2(int[] nums) {
	    if (nums == null || nums.length == 0) return 0;
	    int preSum = nums[0];
	    int maxSum = preSum;
	    for (int i = 1; i < nums.length; i++) {
	        preSum = preSum > 0 ? preSum + nums[i] : nums[i];
	        maxSum = Math.max(maxSum, preSum);
	    }
	    return maxSum;
	}
}
