package com.leetCode;

import java.util.HashMap;

public class E766_ToeplitzMatrix {
	public boolean isToeplitzMatrix(int[][] matrix) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++)
        	map.put(i - 0, matrix[i][0]);
        for (int j = 0; j < matrix[0].length; j++)
        	map.put(0 - j, matrix[0][j]);
        for (int i = 1; i < matrix.length; i++) {
        	for (int j = 1; j < matrix[0].length; j++) {
        		if (map.get(i - j) != matrix[i][j])
        			return false;
        	}
        }
        return true;
    }
}
