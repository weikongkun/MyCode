package com.leetCode;

import java.util.Arrays;

public class E547_FriendCircles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int findCircleNum(int[][] M) {
        boolean[] marked = new boolean[M.length];
        Arrays.fill(marked, false);
        int res = 0;
        for (int i = 0; i < M.length; i++) {
        	if (!marked[i]) {
        		res++;
        		marked[i] = true;
        		dfs(M, i, marked);
        	}
        }
        return res;
    }
	public void dfs(int[][] M, int i, boolean[] marked) {
		int[] arr = M[i];
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == 1 && marked[j] == false) {
				marked[j] = true;
				dfs(M, j, marked);
			}
		}
	}

}
