package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E417_PacificAtlanticWaterFlow {
	int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public List<int[]> pacificAtlantic(int[][] matrix) {
		if (matrix == null || matrix.length == 0) return new ArrayList<>();
		boolean[][] reachP = new boolean[matrix.length][matrix[0].length];
		boolean[][] reachA = new boolean[matrix.length][matrix[0].length];
        
		for (int i = 0; i < matrix.length; i++) {
			reachP[i][0] = true;
			reachA[i][matrix[0].length - 1] = true;
			dfs(matrix, i, 0, reachP);
			dfs(matrix, i, matrix[0].length - 1, reachA);
		}
		for (int i = 0; i < matrix[0].length; i++) {
			reachP[0][i] = true;
			reachA[matrix.length - 1][i] = true;
			dfs(matrix, 0, i, reachP);
			dfs(matrix, matrix.length - 1, i, reachA);
		}
		List<int[]> res = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (reachA[i][j] && reachP[i][j])
					res.add(new int[]{i, j});
			}
		}
		return res;
    }
	
	private void dfs(int[][] matrix, int x, int y, boolean[][] reach) {
		for (int[] arr : direction) {
			int nextX = x + arr[0];
			int nextY = y + arr[1];
			if (nextX >= 0 && nextX < matrix.length &&
					nextY >= 0 && nextY < matrix[0].length && matrix[x][y] <= matrix[nextX][nextY] && !reach[nextX][nextY]) {
				reach[nextX][nextY] = true;
				dfs(matrix, nextX, nextY, reach);
			}
		}
	}
	
}
