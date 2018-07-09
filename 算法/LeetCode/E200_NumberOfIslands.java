package com.leetCode;

public class E200_NumberOfIslands {
	int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if (dfs(grid, i, j)) res++;
        	}
        }
        return res;
    }
	private boolean dfs(char[][] grid, int i, int j) {
		if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == '0') return false;
		grid[i][j] = '0';
		for (int[] arr : direct) {
			dfs(grid, i + arr[0], j + arr[1]);
		}
		return true;
	}
}
