package com.JianZhiOffer;

public class Eg31_GreatestSumOfSubarrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int FindGreatestSumOfSubArray(int[] array) {
		int saveSum = Integer.MIN_VALUE;
		int currentSum = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (currentSum <= 0)
				currentSum = array[i];
			else 
				currentSum += array[i];
			
			if (saveSum < currentSum)
				saveSum = currentSum;
		}
		return saveSum;
	}

}
