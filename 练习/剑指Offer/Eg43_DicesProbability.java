package com.JianZhiOffer;

public class Eg43_DicesProbability {
	public static int times = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(probability(3, 6));
	}
	
	public static double probability(int n, int s) {
		probability(n, 1, 0, s);
		double allSum = Math.pow(6, n);
		System.out.println(times + "/" + allSum);
		return times / allSum;
		
		
	}
	public static void probability(int n, int currentNumber, int currentSum, int s) {
		if (currentSum == s && currentNumber == n + 1) {
			times++;
			return;
		}
		else if (currentSum > s) return;
		else {
			if (currentNumber <= n) {
				for (int i = 1; i <= 6; i++) 
					probability(n, currentNumber + 1, currentSum + i, s);
			}
			else
				 return;
		}
	}

}
