package com.leetCode;

public class E167_TwoSumII_InputArrayIs_Sorted {
	public int[] twoSum(int[] numbers, int target) {
		int lo = 0, hi = numbers.length - 1;
		while (lo < hi) {
			if (numbers[lo] + numbers[hi] == target) break;
			else if (numbers[lo] + numbers[hi] > target) hi--;
			else lo++;
		}
		if (lo >= hi) return new int[] {};
		else return new int[] {lo + 1, hi + 1};
	}
}
