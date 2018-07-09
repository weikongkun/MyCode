package com.leetCode;

import java.util.concurrent.BlockingDeque;

public class E79_WordSearch {
	int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	public boolean exist(char[][] board, String word) {
		if (board == null) return false;
		boolean[][] marked = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(isExist(board, word, 0, i, j, marked))
					return true;
			}
		}
       return false;
    }
	public boolean isExist(char[][] board, String word, int pre, int x, int y, boolean[][] marked) {
		if (pre == word.length()) {
			return true;
		}
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || marked[x][y]) return false;
		if (word.charAt(pre) == board[x][y]) {
			for (int[] arr : direct) {
				marked[x][y] = true;
				if (isExist(board, word, pre + 1, x + arr[0], y + arr[1], marked))
					return true;
				marked[x][y] = false;
			}
		}
		return false;	
	}
}
