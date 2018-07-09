package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E40_CombinationSumII {

	public static void main(String[] args) {

	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates == null || candidates.length == 0) return res;
		Arrays.sort(candidates);
		boolean[] visited = new boolean[candidates.length];
		backStrack(candidates, new ArrayList<>(), target, 0, 0, visited, res);
		return res;
		
	}
	private void backStrack(int[] candidates, List<Integer> list, int target, int now, int start, boolean[] visited, List<List<Integer>> res) {
		if (now == target) {
			res.add(new ArrayList<>(list));
			return;
		}
		if (now > target) return;
		for (int i = start; i < candidates.length; i++) {
			if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) continue;
			list.add(candidates[i]);
			visited[i] = true;
			backStrack(candidates, list, target, now + candidates[i], i, visited, res);
			visited[i] = false;
			list.remove(list.size() - 1);
		}
	}

}
