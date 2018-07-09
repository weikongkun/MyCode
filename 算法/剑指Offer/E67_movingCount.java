package com.JianZhiOffer;

public class E67_movingCount {
	public static void main(String[] args) {
		E67_movingCount test = new E67_movingCount();
		test.movingCount(10, 5, 10);
	}
	int[][] direct = {{0, 1},{0, -1},{-1,0},{1,0}};
	private boolean[][] canGo;
	private int res;
	public int movingCount(int threshold, int rows, int cols) {
        canGo = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) 
        	for (int j = 0; j < cols; j++) {
        		int num = 0;
        		int x = i;
        		while (x > 0) {
        			num += x % 10;
        			x = x / 10;
        		}
        		x = j;
        		while (x > 0) {
        			num += x % 10;
        			x = x / 10;
        		}
        		if (num <= threshold) canGo[i][j] = true;
        	}
        backStrack(0, 0);
        return res;
    }
	
	private void backStrack(int i, int j) {
		if (i < 0 || i >= canGo.length) return;
		if (j < 0 || j >= canGo[0].length) return;
		if (canGo[i][j] == false) return;
		res++;
		canGo[i][j] = false;
		for (int[] arr : direct) {
			backStrack(i + arr[0], j + arr[1]);
		}
	}
}
