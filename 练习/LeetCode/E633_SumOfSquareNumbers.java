package com.leetCode;

public class E633_SumOfSquareNumbers {
	public static void main(String[] args) {
		System.out.println(judgeSquareSum(1000000));
	}
	public static boolean judgeSquareSum(int c) {
        int lo = 0, hi = (int)Math.sqrt(c) + 1;
        while (lo <= hi) {
        	if (lo * lo + hi * hi == c) return true;
        	else if (lo * lo + hi * hi > c) hi--;
        	else lo++;
        }
        return false;
    }
}
