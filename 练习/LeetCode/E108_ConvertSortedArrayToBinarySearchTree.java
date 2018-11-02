package com.leetCode;

public class E108_ConvertSortedArrayToBinarySearchTree {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) return null;
		return sortArray(nums, 0, nums.length - 1);
    }
	public static TreeNode sortArray(int[] nums, int lo, int hi) {
		if (lo > hi) return null;	
		if (lo == hi) return new TreeNode(nums[lo]);
		int mid = (lo + hi) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortArray(nums, lo, mid - 1);
		root.right = sortArray(nums, mid + 1, hi);
		return root;
	}
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {
			val = x;
		}
	}
}
