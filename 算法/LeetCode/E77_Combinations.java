package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class E77_Combinations {
	private int n;
	private int k;
	public static void main(String[] args) {
		System.out.println(new E77_Combinations().combine(3, 2));

	}
	public List<List<Integer>> combine(int n, int k) {
		this.n = n;
		this.k = k;
        List<List<Integer>> res = new ArrayList<>();
        if (k > n || n == 0 || k == 0) return res;
        boolean[] visited = new boolean[n + 1];
        backtrack(new ArrayList<>(), 1, res, visited);
        return res;
    }
	public void backtrack(List<Integer> list, int pre, List<List<Integer>> res, boolean[] visited) {
		if (pre == k + 1) {
			res.add(new ArrayList<>(list));
			return;
		}
		
		for (int i = list.size() == 0 ? 1 : list.get(list.size() - 1) + 1; i <= n; i++) {
			if (visited[i] == true) continue;
			list.add(i);
			visited[i] = true;
			backtrack(list, pre + 1, res, visited);
			visited[i] = false;
			list.remove(list.size() - 1);
		}
	}

}
