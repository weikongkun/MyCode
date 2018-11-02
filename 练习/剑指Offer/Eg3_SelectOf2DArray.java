package com.JianZhiOffer;

public class Eg3_SelectOf2DArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{1, 2, 3}, {2, 5, 6}, {3, 6, 9}};
		int[][] arr1 = null;
		System.out.println(select(arr1, 5));

	}
	
	public static boolean select(int[][] arr, int num) {
		if (arr == null)
			return false;
		int row = arr.length - 1;
		int column = arr[row].length - 1;
		int k = 0;
		while (k <= row && column >= 0) {
			if (arr[k][column] > num)
				column--;
			else if (arr[k][column] < num)
				k++;
			else
				return true;
		}
		
		return false;
	}

}
