package com.leetCode;

public class E215_KthLargestElementInAnArray {
	public static void main(String[] args) {
		E215_KthLargestElementInAnArray test = new E215_KthLargestElementInAnArray();
		int[] nums = {3, 2, 1, 5, 6, 4};
		int k = 2;
		System.out.println(test.findKthLargest(nums, k));
	}
	public int findKthLargest(int[] nums, int k) {
		return findKth(nums, 0, nums.length, k);
	}
	public int findKth(int[] nums, int i, int j, int k) {
		int p = partation(nums, i, j);
		if (p == nums.length - k) return nums[p];
		else if (p < nums.length - k) return findKth(nums, p + 1, j, k);
		else return findKth(nums, i, p - 1, k);
	}
	public int partation(int[] arr, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		int num = arr[lo];
		while (true) {
			while (arr[++i] < num) if (i == hi) break;
			while (arr[--j] >= num) if (j == lo) break;
			if (i >= j) break;
			swap(arr, i, j);
		}
		swap(arr, lo, j);
		return j;
	}
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i]^nums[j];
		nums[i] = temp ^ nums[i];
		nums[j] = temp ^ nums[i];
	}
} 
