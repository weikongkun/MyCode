package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E51_N_Queens {
	private List<List<String>> res;
	private int n;
	public static void main(String[] args) {
		E51_N_Queens test = new E51_N_Queens();
		test.solveNQueens(2);
		for (List<String> list: test.res) {
			System.out.println(list);
		}
	}
	public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        this.n = n;
        char[][] subRes = new char[n][n];
        for (int i = 0; i < subRes.length; i++) 
        	Arrays.fill(subRes[i], '.');
        boolean[] placed = new boolean[n];
        boolean[] diagonal = new boolean[2 * n - 1];
        boolean[] backdiagonal = new boolean[2 * n - 1];
        backtracking(0, placed, subRes, diagonal, backdiagonal);
        return res;
    }
	private void backtracking(int cur, boolean[] placed, char[][] subRes, boolean[] diagonal, boolean[] backdiagonal) {
		if (cur == n) {
			res.add(oneRes(subRes));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (placed[i] || diagonal[i - cur + n - 1] || backdiagonal[i + cur]) continue;
			
			placed[i] = true;
			subRes[i][cur] = 'Q';
			diagonal[i - cur + n - 1] = true;
			backdiagonal[i + cur] = true;
			backtracking(cur + 1, placed, subRes, diagonal, backdiagonal);
			diagonal[i - cur + n - 1] = false;
			backdiagonal[i + cur] = false;
			subRes[i][cur] = '.';
			placed[i] = false;
		}
	}
	
	private List<String> oneRes(char[][] subRes) {
		List<String> oneRes = new ArrayList<>();
		for (int i = 0; i < subRes.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < subRes[0].length; j++) 
				sb.append(subRes[i][j]);
			oneRes.add(sb.toString());
		}
		return oneRes;
	}

}
