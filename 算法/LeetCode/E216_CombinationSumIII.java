package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class E216_CombinationSumIII {

	public static void main(String[] args) {
		

	}
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > 9) return res;
        backTrack(new ArrayList<>(), 0, n, 1, k, res);
        return res;
    }
	
	private void backTrack(List<Integer> list, int now, int target, int start, int k, List<List<Integer>> res) {
		if (now == target && k == list.size()) {
			res.add(new ArrayList<>(list));
			return;
		}
		if (now >=	 target || k <= list.size())
			return;
		for (int i = start; i <= 9; i++) {
			list.add(i);
			backTrack(list, now + i, target, i + 1, k, res);
			list.remove(list.size() - 1);
		}
	}
	

}
