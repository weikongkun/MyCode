package com.leetCode;

import java.util.Arrays;

public class E179_LargestNumber {

	public static void main(String[] args) {
		int[] nums = {3, 30, 34, 5, 9};
		System.out.println(largestNumber(nums));

	}
	
	public static String largestNumber(int[] nums) {
		StringBuffer sB = new StringBuffer();
		Arrays.sort(nums);
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();
		int[] copyOfNums = Arrays.copyOf(nums, nums.length);
		int max = 1;
		while (max < nums[nums.length - 1])
			max *= 10;
		
		for (int i = 0; i < nums.length; i++) {
			while (10 * copyOfNums[i] < max)
				copyOfNums[i] *= 10;
		}
		for (int i : copyOfNums) {
			System.out.print(i + " ");
		}
		System.out.println();
		//插入排序
		for (int i = 1; i < copyOfNums.length; i++) {
			for (int j = i; j > 0; j--) {
				if (copyOfNums[j - 1] >= copyOfNums[j]) {
					swap(copyOfNums, j, j - 1);
					swap(nums, j, j - 1);
				}
				else break;
			}
		}
		//冒泡排序
//		for (int i = copyOfNums.length - 1; i > 0; i--) {
//			for (int j = 0; j < i; j++) {
//				if (copyOfNums[j] >= copyOfNums[j + 1]) {
//					swap(copyOfNums, j, j + 1);
//					swap(nums, j, j + 1);
//				}
//			}
//		}
		
		System.out.println();
		for (int i : copyOfNums) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for (int i = nums.length - 1; i >= 0; i--) {
			sB.append(nums[i]);
		}
		return sB.toString();
	}
	
	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i] ^ nums[j];
		nums[i] = temp ^ nums[i];
		nums[j] = temp ^ nums[i];
	}

}
