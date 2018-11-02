package com.leetCode;

import java.util.Arrays;
import java.util.HashMap;

public class FourSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
        	for (int j = 0; j < B.length; j++) {
        		int sum = A[i] + B[j];
        		map1.put(sum, map1.getOrDefault(sum, 0) + 1);
        	}
        }
        int res = 0;
        for (int i = 0; i < C.length; i++) {
        	for (int j = 0; j < D.length; j++) {
        		int sum = -(C[i] + D[j]);
        		res += map1.getOrDefault(sum, 0);
        	}
        }
        
        return res;
    }

}
