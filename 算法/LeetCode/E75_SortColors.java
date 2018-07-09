package com.leetCode;

public class E75_SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 0, 1};
		sortColors(nums);
		for ( int i : nums) {
			System.out.print(i + " ");
		}
	}
	
	public static void sortColors(int[] nums) {
		int lo = 0, hi = nums.length - 1;
		for (int i = 0; i < hi; i++) {
			while (nums[i] == 2 && i < hi) exch(nums, i, hi--);
			while (nums[i] == 0 && i > lo) exch(nums, i, lo++);
		}
		
	}
	public static void exch(int[] nums, int i, int j) {
		int temp = nums[i] ^ nums[j];
		nums[i] = temp ^ nums[i];
		nums[j] = temp ^ nums[i];
	}

}
