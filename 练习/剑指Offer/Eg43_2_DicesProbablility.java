package com.JianZhiOffer;

public class Eg43_2_DicesProbablility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(probablility(3, 6));
	}
	
	public static double probablility(int n, int sum) {
		int[] arr1 = new int[n * 6 + 1];
		for (int i = 1; i <= 6; i++)
			arr1[i] = 1;
		for (int i = 7; i < arr1.length; i++)
			arr1[i] = 0;
		
		for (int i = 2; i <= n; i++) {
			for (int j = arr1.length - 1; j >= 1; j--) {
				arr1[j] = 0;
				for (int k = j - 1; k >= j - 6; k--) {
					if (k < 1) break;
					else arr1[j] += arr1[k];
				}
			}
		}
		
		double allSum = Math.pow(6, n);
		System.out.println(arr1[sum] + "/" + allSum);
		return arr1[sum] / allSum;
	}

}
