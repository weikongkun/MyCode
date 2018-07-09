package com.JianZhiOffer;

import java.util.ArrayList;

public class Eg20_PrintMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m = {{1,2}, {4,3}};
		ArrayList<Integer> list = printmatrix(m);
		for (int i :list) 
			System.out.print(i + " ");

	}
	
	public static ArrayList<Integer> printmatrix(int [][] matrix) {
	       ArrayList<Integer> list = new ArrayList<>();
	        int l = matrix[0].length;
	        int w = matrix.length;
	        
	        int w1 = 0, w2 = w - 1, l1 = 0, l2 = l - 1;
	        while (l1 <= l2 && w1 <= w2) {
	            if (l1 == l2 && w1 < w2) {
	                for (int k = w1; k <= w2; k++) 
	                    list.add(matrix[k][l1]);
	                break;
	            }
	            else if (l1 < l2 && w1 == w2) {
	                for (int k = l1; k <= l2; k++)
	                    list.add(matrix[w1][k]);
	                break;
	            }
	            else if (l1 == l2 && w1 == w2) {
	                list.add(matrix[l1][w1]);
	                break;
	            }
	            else {
	                for (int p = l1; p <= l2; p++)
	                    list.add(matrix[w1][p]);
	                for (int p = w1 + 1; p <= w2; p++)
	                    list.add(matrix[p][l2]);
	                for (int p = l2 - 1; p >= l1; p--)
	                    list.add(matrix[w2][p]);
	                for (int p = w2 - 1; p > w1; p--)
	                    list.add(matrix[p][l1]);
	                l1++; l2--; w1++; w2--;
	                    
	            }
	            
	        }
	        return list;
	    }

	public static ArrayList<Integer> printmatrix2(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<>();
		return list;
	}

}
