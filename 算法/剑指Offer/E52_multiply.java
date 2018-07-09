package com.JianZhiOffer;

public class E52_multiply {
	public int[] multiply(int[] A) {
		int n = A.length;
		int[] C = new int[n];
		int[] D = new int[n];
		C[0] = 1;
		D[n - 1] = 1;
		for (int i = 1; i < n; i++) {
			C[i] = A[i - 1] * C[i - 1];
		}
		for (int i = n - 2; i >= 0; i--) 
			D[i] = D[i + 1] * A[i + 1];
		int[] res = new int[n];
		for (int i = 0; i < n; i++) 
			res[i] = C[i] * D[i];
		return res;
    }
}
