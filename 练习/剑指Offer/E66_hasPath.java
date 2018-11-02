package com.JianZhiOffer;

public class E66_hasPath {
	public static void main(String[] args) {
		E66_hasPath test = new E66_hasPath();
		char[] matrix = "A".toCharArray();
		int rows = 1;
		int cols = 1;
		char[] str = "A".toCharArray();
		System.out.println(test.hasPath(matrix, rows, cols, str));
	}
	int[][] direct = {{0, 1},{0, -1},{-1,0},{1,0}};
	char[][] mat;
	char[] str;
	boolean[][] bo;
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if (str.length == 0 || matrix == null || matrix.length == 0) return false;
		mat = new char[rows][cols];
		this.str = str;
		this.bo = new boolean[rows][cols];
		for (int i = 0; i < matrix.length; i++) {
			mat[i / cols][i % cols] = matrix[i];
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (path(i, j, 0)) return true;
			}
		}
		return false;
    }
	private boolean path(int i, int j, int cur) {
		if (cur == str.length) return true;
		if (i < 0 || i >= mat.length) return false;
		if (j < 0 || j >= mat[0].length) return false;
		if (bo[i][j]) return false;
		if (str[cur] == mat[i][j]) {
			bo[i][j] = true;
			for (int[] dir : direct) {
				if (path(i + dir[0] , j + dir[1], cur + 1)) return true;
			}
			bo[i][j] = false;
		}
		return false;
	}
}
