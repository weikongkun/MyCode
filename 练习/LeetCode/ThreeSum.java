package com.leetCode;

import java.util.*;

public class ThreeSum {
	
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		System.out.println(((ArrayList<List<Integer>>)threeSum(nums)).toString());
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) break;
			int sum = 0 - nums[i];
			int lo = i + 1, hi = nums.length - 1;
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			
			while (lo < hi) {
				if (nums[lo] + nums[hi] == sum) {
					List<Integer> subList = new ArrayList<>();
					subList.add(nums[i]);
					subList.add(nums[lo]);
					subList.add(nums[hi]);
					res.add(subList);
					while (lo < hi && nums[lo] == nums[lo + 1])
						lo++;
					while (lo < hi && nums[hi] == nums[hi - 1])
						hi--;
					lo++;
					hi--;
				}
				
				
				else if (nums[lo] + nums[hi] < sum)
					lo++;
				else 
					hi--;
			}
		}
		return res;
	}
}