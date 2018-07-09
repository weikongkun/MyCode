package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class E39_CombinationSum {
	public static void main(String[] args) {
		System.out.println(new E39_CombinationSum().combinationSum(new int[] {2, 3, 6, 7}, 7));
	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        backtrack(new ArrayList<>(), new ArrayList<>(), 0, candidates, target, res);
        return res;
    }
	private void backtrack(List<Integer> list, List<Integer> indexArray, int now, int[] candidates, int target, List<List<Integer>> res) {
		if (now == target) {
			res.add(new ArrayList<>(list));
			return;
		}
		if (now > target) return;
		for (int i = indexArray.size() == 0 ? 0 : indexArray.get(indexArray.size() - 1); i < candidates.length; i++) {
			list.add(candidates[i]);
			indexArray.add(i);
			backtrack(list, indexArray, now + candidates[i], candidates, target, res);
			indexArray.remove(indexArray.size() - 1);
			list.remove(list.size() - 1);
		}
	}
}
