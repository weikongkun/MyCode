package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E90_SubsetsII {

	private List<List<Integer>> ret;
	private List<Integer> subsetList;
	private boolean[] visited;

	public List<List<Integer>> subsetsWithDup(int[] nums) {
	    ret = new ArrayList<>();
	    subsetList = new ArrayList<>();
	    visited = new boolean[nums.length];
	    Arrays.sort(nums);

	    for (int i = 0; i <= nums.length; i++)
	        backtracking(0, i, nums);

	    return ret;
	}

	private void backtracking(int startIdx, int size, int[] nums) {
	    if (subsetList.size() == size) {
	        ret.add(new ArrayList(subsetList));
	        return;
	    }
	    for (int i = startIdx; i < nums.length; i++) {
	        if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])
	            continue;
	        subsetList.add(nums[i]);
	        visited[i] = true;
	        backtracking(i + 1, size, nums);
	        visited[i] = false;
	        subsetList.remove(subsetList.size() - 1);
	    }
	}
	

}
