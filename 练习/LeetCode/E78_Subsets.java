package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class E78_Subsets {

	public static void main(String[] args) {
		System.out.println(new E78_Subsets().subsets(new int[] {1, 2, 3}));
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length == 0 || nums == null) return res;
		backtrack(nums, new ArrayList<>(), 0, res);
		return res;
		
	}
	private void backtrack(int[] nums, List<Integer> list, int now, List<List<Integer>> res) {
		if (now == nums.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		list.add(nums[now]);
		backtrack(nums, list, now + 1, res);
		list.remove(list.size() - 1);
		backtrack(nums, list, now + 1, res);
	}
	
	//=======================method2位运算======================
	public List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length == 0 || nums == null) return res;
		for (int i = 0; i < (1 << nums.length); i++) 
			addSubsets(nums, i, res);
		return res;
	}
	private void addSubsets(int[] nums, int s, List<List<Integer>> res) {
		ArrayList<Integer> subset = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if ((s & (1<<i)) == 0)
				subset.add(nums[i]);
		}
		res.add(subset);
	}

}
