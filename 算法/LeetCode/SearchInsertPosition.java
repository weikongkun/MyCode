package com.leetCode;

public class SearchInsertPosition {
	public static void main(String[] args) {
		int[] arr = new int[] {1, 3, 5, 6};
		System.out.println(searchInsert(arr, 0));
	}
	public static int searchInsert(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1;
		int mid = 0;
		while (lo <= hi) {
			mid = (lo + hi) / 2;
			if (nums[mid] == target) return mid;
			else if (target < nums[mid]) hi = mid - 1;
			else lo = mid + 1;
		}
		return lo;
	}
}
