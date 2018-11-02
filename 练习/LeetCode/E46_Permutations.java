package com.leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class E46_Permutations {

	public static void main(String[] args) {
		System.out.print(permute(new int[] {1, 2, 3, 3}).size());
	}
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null && nums.length == 0) return res;
        backtracking(nums, new ArrayList<>(), 0, res);
        return res;
    }
	
	private static void backtracking(int[] nums, List<Integer> indexList, int pre, List<List<Integer>> res) {
		if (pre == nums.length) {
			List<Integer> oneOfRes = new ArrayList<>();
			for (int i = 0; i < indexList.size(); i++) {
				oneOfRes.add(nums[indexList.get(i)]);
			}
			res.add(oneOfRes);
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!indexList.contains(i)) {
				indexList.add(i);
				backtracking(nums, indexList, pre + 1, res);
				indexList.remove(indexList.size() - 1);
			}
		}
	}

}
