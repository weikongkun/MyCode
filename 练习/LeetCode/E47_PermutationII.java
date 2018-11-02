package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E47_PermutationII {
	public List<List<Integer>> permuteUnique(int[] nums) {
	    List<List<Integer>> res = new ArrayList<>();
	    if (nums == null || nums.length == 0) return res;
	    boolean[] marked = new boolean[nums.length];
	    Arrays.sort(nums);
	    backtracking(new ArrayList<>(), marked, nums, res);
	    return res;
	}

	private void backtracking(List<Integer> permuteList, boolean[] visited, int[] nums, List<List<Integer>> ret) {
	    if (permuteList.size() == nums.length) ret.add(new ArrayList<>(permuteList));
	    for (int i = 0; i < nums.length; i++) {
	    	if ((i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) || visited[i]) continue;
	    	visited[i] = true;
	    	permuteList.add(nums[i]);
	    	backtracking(permuteList, visited, nums, ret);
	    	permuteList.remove(permuteList.size() - 1);
	    	visited[i] = false;
	    	
	    }
	}
}
