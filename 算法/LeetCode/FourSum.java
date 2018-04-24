package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public static void main(String[] args) {
		int[] nums = {1,-2,-5,-4,-3,3,3,5};
		System.out.println(fourSum1(nums, -11).toString());
	}

	public static List<List<Integer>> fourSum1(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
//		for (int i = 0; i < nums.length; i++)
//			System.out.println(nums[i]);
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i - 1] == nums[i])
				continue;
			int l1 = i + 1;
			int t1 = target - nums[i];
			for (int j = l1; j < nums.length; j++) {
				if (j > l1 && nums[j - 1] == nums[j])
					continue;
				int l2 = j + 1, h2 = nums.length - 1;
				int t2 = t1 - nums[j];
				while (l2 < h2) {
					if (t2 == nums[l2] + nums[h2]) {
						List<Integer> sublist = new ArrayList<>();
						sublist.add(nums[i]);
						sublist.add(nums[j]);
						sublist.add(nums[l2]);
						sublist.add(nums[h2]);
						res.add(sublist);
						while (l2 < h2 && nums[l2] == nums[l2 + 1])
							l2++;
						while (l2 < h2 && nums[h2] == nums[h2 - 1])
							h2--;
						l2++;
						h2--;
					} else if (t2 < nums[l2] + nums[h2])
						h2--;
					else
						l2++;
				}
			}
		}
		return res;
	}
}
